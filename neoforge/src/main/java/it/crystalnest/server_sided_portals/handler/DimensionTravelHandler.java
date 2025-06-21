package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * Handles {@link PlayerEvent.PlayerChangedDimensionEvent}s.
 */
@EventBusSubscriber(modid = Constants.MOD_ID)
public final class DimensionTravelHandler extends GamemodeChangeHandler {
  /**
   * Singleton instance for this event handler.
   */
  private static final DimensionTravelHandler INSTANCE = new DimensionTravelHandler();

  private DimensionTravelHandler() {}

  /**
   * Handles the {@link PlayerEvent.PlayerChangedDimensionEvent}.
   *
   * @param event {@link PlayerEvent.PlayerChangedDimensionEvent}.
   */
  @SubscribeEvent
  public static void handle(PlayerEvent.PlayerChangedDimensionEvent event) {
    if (event.getEntity() instanceof ServerPlayer player) {
      INSTANCE.handle(player, event.getTo());
    }
  }
}
