package it.crystalnest.server_sided_portals.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Dimension tweak.
 *
 * @param dimension dimension it's for.
 * @param connection dimension to be connected to.
 * @param permission permission tweak.
 * @param gamemodes list of gamemode tweaks.
 */
public record DimensionTweak(ResourceKey<Level> dimension, ResourceKey<Level> connection, PermissionTweak permission, List<GamemodeTweak> gamemodes) {
  /**
   * {@link DimensionTweak} {@link Codec}.
   */
  public static final Codec<DimensionTweak> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    ResourceKey.codec(Registries.DIMENSION).fieldOf("dimension").forGetter(DimensionTweak::dimension),
    // Portals of the specified dimension will activate only within the connection dimension or within the specified dimension itself; in the latter case, they will lead back to the connection dimension.
    ResourceKey.codec(Registries.DIMENSION).optionalFieldOf("connection", Level.OVERWORLD).forGetter(DimensionTweak::connection),
    PermissionTweak.CODEC.optionalFieldOf("permission", PermissionTweak.DEFAULT_PERMISSION).forGetter(DimensionTweak::permission),
    GamemodeTweak.CODEC.listOf().optionalFieldOf("gamemode", List.of()).forGetter(DimensionTweak::gamemodes)
  ).apply(instance, DimensionTweak::new));

  /**
   * Default dimension tweak connected to the Overworld.
   */
  public static final DimensionTweak OVERWORLD_CONNECTION = new DimensionTweak(null, Level.OVERWORLD, PermissionTweak.DEFAULT_PERMISSION, List.of());
}
