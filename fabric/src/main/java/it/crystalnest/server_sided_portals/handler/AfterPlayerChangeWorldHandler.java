package it.crystalnest.server_sided_portals.handler;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

/**
 * Handles {@link ServerEntityWorldChangeEvents}.
 */
public final class AfterPlayerChangeWorldHandler extends GamemodeChangeHandler {
  /**
   * Singleton instance for this event handler.
   */
  private static final AfterPlayerChangeWorldHandler INSTANCE = new AfterPlayerChangeWorldHandler();

  private AfterPlayerChangeWorldHandler() {}

  /**
   * Handles {@link ServerEntityWorldChangeEvents}.
   *
   * @param player player travelling.
   * @param origin origin dimension.
   * @param destination destination dimension.
   */
  public static void handle(ServerPlayer player, ServerLevel origin, ServerLevel destination) {
    INSTANCE.handle(player, destination.dimension());
  }
}
