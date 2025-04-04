package it.crystalnest.server_sided_portals.api;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Dimension tweak.
 *
 * @param dimension dimension it's for.
 * @param connection dimension to be connected to.
 * @param gamemode list of type tweaks.
 */
public record DimensionTweak(ResourceKey<Level> dimension, ResourceKey<Level> connection, List<GamemodeTweak> gamemode) {
  /**
   * Default dimension tweak connected to the Overworld.
   */
  public static final DimensionTweak OVERWORLD_CONNECTION = new DimensionTweak(null, Level.OVERWORLD, List.of());

  public DimensionTweak {
    if (connection == null) {
      connection = Level.OVERWORLD;
    }
    if (gamemode == null) {
      gamemode = List.of();
    }
  }
}
