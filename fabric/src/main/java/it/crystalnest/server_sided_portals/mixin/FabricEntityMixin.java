package it.crystalnest.server_sided_portals.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import it.crystalnest.server_sided_portals.api.CustomPortalChecker;
import net.fabricmc.fabric.impl.dimension.Teleportable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.PortalInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Injects into {@link Entity} to alter dimension travel.
 */
@Mixin(Entity.class)
public abstract class FabricEntityMixin {
  /**
   * Shadowed {@link Entity#portalEntrancePos}.
   */
  @Shadow
  protected BlockPos portalEntrancePos;

  /**
   * Redirects the call to {@link Entity#handleNetherPortal()} inside the method {@link Entity#tick()}.<br>
   * Changes the {@link PortalInfo} if the entity is in a Nightworld Portal.
   *
   * @param instance {@link Entity} owning the redirected method.
   * @param destination dimension.
   * @return entity in the new dimension.
   */
  @SuppressWarnings("UnstableApiUsage")
  @WrapOperation(method = "handleNetherPortal", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;changeDimension(Lnet/minecraft/server/level/ServerLevel;)Lnet/minecraft/world/entity/Entity;"))
  private Entity redirectChangeDimension(Entity instance, ServerLevel destination, Operation<Entity> original) {
    ServerLevel actualDestination = CustomPortalChecker.getActualPortalDestination((ServerLevel) instance.level, portalEntrancePos);
    if (!instance.level.isClientSide && !instance.isRemoved() && CustomPortalChecker.isCustomPortal(instance.level, portalEntrancePos)) {
      ((Teleportable) this).fabric_setCustomTeleportTarget(CustomPortalChecker.getCustomPortalInfo(instance, actualDestination));
    }
    return original.call(instance, actualDestination);
  }

  /**
   * Injects into the method {@link Entity#changeDimension(ServerLevel)} after the call to {Entity#getTeleportTarget(ServerWorld)}.<br>
   * Resets the {@link net.fabricmc.fabric.mixin.dimension.EntityMixin#customTeleportTarget customTeleportTarget}.
   *
   * @param destination dimension.
   * @param cir {@link CallbackInfoReturnable}.
   */
  @SuppressWarnings("UnstableApiUsage")
  @Inject(method = "changeDimension", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;findDimensionEntryPoint(Lnet/minecraft/server/level/ServerLevel;)Lnet/minecraft/world/level/portal/PortalInfo;", shift = Shift.AFTER))
  private void onChangeDimension(ServerLevel destination, CallbackInfoReturnable<Entity> cir) {
    ((Teleportable) this).fabric_setCustomTeleportTarget(null);
  }
}
