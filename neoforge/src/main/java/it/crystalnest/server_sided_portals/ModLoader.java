package it.crystalnest.server_sided_portals;

import it.crystalnest.server_sided_portals.handler.ResourceReloadListener;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import org.jetbrains.annotations.ApiStatus;

/**
 * Mod loader.
 */
@ApiStatus.Internal
@Mod(Constants.MOD_ID)
public final class ModLoader {
  /**
   * Mod initialization.
   *
   * @param bus Event bus.
   */
  public ModLoader(IEventBus bus) {
    CommonModLoader.init();
    NeoForge.EVENT_BUS.addListener((AddServerReloadListenersEvent event) -> event.addListener(Constants.DIMENSION_TWEAKS_ID, new ResourceReloadListener()));
  }
}
