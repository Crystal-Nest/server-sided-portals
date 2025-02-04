package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import it.crystalnest.server_sided_portals.command.DimensionCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public final class CommandsEventHandler {
  private CommandsEventHandler() {}

  @SubscribeEvent
  public static void handle(RegisterCommandsEvent event) {
    DimensionCommand.register(event.getDispatcher());
  }
}
