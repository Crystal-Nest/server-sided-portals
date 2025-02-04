package it.crystalnest.server_sided_portals;

import it.crystalnest.server_sided_portals.command.DimensionCommand;
import it.crystalnest.server_sided_portals.handler.UseBlockHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
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
    CommandRegistrationCallback.EVENT.register((dispatcher, context, selection) -> DimensionCommand.register(dispatcher));
  }
}
