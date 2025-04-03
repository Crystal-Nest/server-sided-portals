package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

/**
 * Handles datapack reload events.
 */
@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public final class ResourceReloadListener extends CommonResourceReloadListener {
  /**
   * Handles the {@link AddReloadListenerEvent}.
   *
   * @param event {@link AddReloadListenerEvent}.
   */
  @SubscribeEvent
  public static void handle(AddReloadListenerEvent event) {
    event.addListener(new ResourceReloadListener());
  }
}
