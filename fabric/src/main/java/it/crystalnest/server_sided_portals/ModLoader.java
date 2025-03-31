package it.crystalnest.server_sided_portals;

import it.crystalnest.server_sided_portals.handler.AfterPlayerChangeWorldHandler;
import it.crystalnest.server_sided_portals.handler.ResourceReloadListener;
import it.crystalnest.server_sided_portals.handler.UseBlockHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.ApiStatus;

/**
 * Mod loader.
 */
@ApiStatus.Internal
public final class ModLoader implements ModInitializer {
  @Override
  public void onInitialize() {
    CommonModLoader.init();
    UseBlockCallback.EVENT.register(UseBlockHandler::handle);
    ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new ResourceReloadListener());
    ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register(AfterPlayerChangeWorldHandler::handle);
  }
}
