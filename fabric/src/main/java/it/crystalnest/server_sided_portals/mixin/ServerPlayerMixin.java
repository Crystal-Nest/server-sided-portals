package it.crystalnest.server_sided_portals.mixin;

import it.crystalnest.server_sided_portals.api.CustomPortalChecker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.portal.TeleportTransition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Injects into {@link ServerPlayer} to enforce dimension travel permissions.
 */
@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
  /**
   * Injects at the start of the method {@link ServerPlayer#teleport(TeleportTransition)}.<br>
   * Rejects the transition when the player cannot enter its destination.
   *
   * @param transition requested dimension transition.
   * @param cir callback information used to reject a disallowed transition.
   */
  @Inject(method = "teleport(Lnet/minecraft/world/level/portal/TeleportTransition;)Lnet/minecraft/server/level/ServerPlayer;", at = @At(value = "HEAD"), cancellable = true)
  private void onTeleport(TeleportTransition transition, CallbackInfoReturnable<ServerPlayer> cir) {
    if (CustomPortalChecker.cannotTravel((ServerPlayer) (Object) this, transition.newLevel().dimension())) {
      cir.setReturnValue(null);
    }
  }
}
