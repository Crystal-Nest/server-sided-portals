package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import it.crystalnest.server_sided_portals.api.DimensionTweak;
import it.crystalnest.server_sided_portals.api.GamemodeTweak;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

/**
 * Handler for dimension travel events related to type changes.
 */
public abstract class GamemodeChangeHandler {
  /**
   * Handles a player travelling to a dimension by optionally changing its type.
   *
   * @param player player travelling.
   * @param dimension destination dimension.
   */
  protected void handle(ServerPlayer player, ResourceKey<Level> dimension) {
    DimensionTweak dimensionTweak = Constants.DIMENSION_TWEAKS.get(dimension);
    if (dimensionTweak != null) {
      for (GamemodeTweak tweak : dimensionTweak.gamemode()) {
        if (tweak.whitelist() == (player.server.getProfilePermissions(player.getGameProfile()) >= tweak.permission() || tweak.players().stream().anyMatch(profile -> player.getStringUUID().equalsIgnoreCase(profile)))) {
          player.setGameMode(tweak.type());
          break;
        }
      }
    }
  }
}
