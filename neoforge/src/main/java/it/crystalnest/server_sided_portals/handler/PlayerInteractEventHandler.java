package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.minecraft.world.InteractionResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

/**
 * Handles {@link PlayerInteractEvent.RightClickBlock}s.
 */
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class PlayerInteractEventHandler extends ItemUseHandler {
  /**
   * Singleton instance for this event handler.
   */
  private static final PlayerInteractEventHandler INSTANCE = new PlayerInteractEventHandler();

  private PlayerInteractEventHandler() {}

  /**
   * Handles the {@link PlayerInteractEvent.RightClickBlock}.
   *
   * @param event {@link PlayerInteractEvent.RightClickBlock}.
   */
  @SubscribeEvent
  public static void handle(PlayerInteractEvent.RightClickBlock event) {
    if (!event.getEntity().getItemInHand(event.getHand()).isEmpty() && INSTANCE.handle(event.getLevel(), event.getEntity(), event.getHand(), event.getPos(), event.getFace())) {
      event.setCancellationResult(InteractionResult.SUCCESS);
      event.setCanceled(true);
    }
  }
}
