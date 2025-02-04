package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import it.crystalnest.server_sided_portals.api.CustomPortalChecker;
import it.crystalnest.server_sided_portals.api.Teleportable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

/**
 * {@link EntityTravelToDimensionEvent} handler.
 */
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class EntityTravelToDimensionEventHandler {
  private EntityTravelToDimensionEventHandler() {}

  /**
   * Handles the {@link EntityTravelToDimensionEvent} by optionally setting the custom portal info for the entity.
   *
   * @param event {@link EntityTravelToDimensionEvent}.
   */
  @SubscribeEvent
  public static void handle(EntityTravelToDimensionEvent event) {
    Entity entity = event.getEntity();
    MinecraftServer server = entity.getServer();
    if (server != null && !entity.isRemoved() && (CustomPortalChecker.hasCustomPortalFrame(entity.level().dimension()) || CustomPortalChecker.hasCustomPortalFrame(event.getDimension()))) {
      ((Teleportable) entity).setCustomPortalInfo(CustomPortalChecker.getCustomPortalInfo(entity, Objects.requireNonNull(server).getLevel(event.getDimension())));
    }
  }
}
