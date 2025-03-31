package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;

/**
 * Handles datapack reload events.
 */
@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public final class ResourceReloadListener extends CommonResourceReloadListener {
  /**
   * Handles the {@link AddServerReloadListenersEvent}.
   *
   * @param event {@link AddServerReloadListenersEvent}.
   */
  @SubscribeEvent
  public static void handle(AddServerReloadListenersEvent event) {
    event.addListener(Constants.DIMENSION_TWEAKS_ID, new ResourceReloadListener());
  }
}
