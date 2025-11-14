package it.crystalnest.server_sided_portals.mixin;

import it.crystalnest.server_sided_portals.api.CustomPortalChecker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Injects into {@link Entity} and {@link ServerPlayer} to alter dimension travel.
 */
@Mixin({Entity.class, ServerPlayer.class})
public abstract class EntityMixin {
  /**
   * Injects at the start of the method {@link Entity#changeDimension(DimensionTransition)}.<br>
   * Checks if the entity can travel to the dimension.
   *
   * @param transition dimension transition.
   * @param cir {@link CallbackInfoReturnable}.
   */
  @Inject(method = "changeDimension", at = @At(value = "HEAD"), cancellable = true)
  private void onChangeDimension(DimensionTransition transition, CallbackInfoReturnable<Entity> cir) {
    if (CustomPortalChecker.cannotTravel((Entity) (Object) this, transition.newLevel().dimension())) {
      cir.setReturnValue(null);
    }
  }
}
