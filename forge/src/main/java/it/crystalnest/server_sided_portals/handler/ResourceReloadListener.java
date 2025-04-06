package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles datapack reload events.
 */
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
