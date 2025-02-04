package it.crystalnest.server_sided_portals.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import it.crystalnest.server_sided_portals.api.CustomPortalChecker;
import it.crystalnest.server_sided_portals.api.EntityPortal;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

/**
 * Injects into {@link Entity} to alter dimension travel.
 */
@Mixin(Entity.class)
public abstract class ForgeEntityMixin implements EntityPortal {
  /**
   * Shadowed {@link Entity#level()}.
   *
   * @return level.
   */
  @Shadow
  public abstract Level level();

  /**
   * Modifies the call to {@link MinecraftServer#getLevel(ResourceKey)} inside the method {@link Entity#handleNetherPortal()}.<br>
   * Returns the correct destination dimension.
   *
   * @param original {@link ServerLevel} original destination.
   * @return correct destination dimension.
   */
  @ModifyExpressionValue(method = "handleNetherPortal", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getLevel(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/server/level/ServerLevel;"))
  private ServerLevel redirectGetLevel(@Nullable ServerLevel original) {
    return CustomPortalChecker.getPortalDestination((ServerLevel) level(), Objects.requireNonNull(original), portalEntrancePos());
  }
}
