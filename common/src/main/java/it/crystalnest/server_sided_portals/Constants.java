package it.crystalnest.server_sided_portals;

import it.crystalnest.server_sided_portals.api.DimensionTweak;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Common shared constants across all loaders.
 */
@ApiStatus.Internal
public final class Constants {
  /**
   * Mod ID.
   */
  public static final String MOD_ID = "server_sided_portals";

  /**
   * Mod logger.
   */
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  /**
   * {@link ThreadLocal} to keep track of a player's origin dimension when teleporting through a custom portal.
   */
  public static final ThreadLocal<ResourceKey<Level>> DIMENSION_ORIGIN_THREAD = ThreadLocal.withInitial(() -> Level.OVERWORLD);

  /**
   * {@link Identifier} of possible dimension tweaks.
   */
  public static final Identifier DIMENSION_TWEAKS_ID = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tweaks");

  /**
   * Loaded dimension tweaks.
   */
  public static final Map<ResourceKey<Level>, DimensionTweak> DIMENSION_TWEAKS = new HashMap<>();

  private Constants() {}

  /**
   * Returns the dimension tweak for the given dimension.<br>
   * Returns a default value if no dimension tweak was specified for the given dimension.
   *
   * @param dimension dimension.
   * @return dimension tweak.
   */
  public static DimensionTweak getTweak(ResourceKey<Level> dimension) {
    return Constants.DIMENSION_TWEAKS.getOrDefault(dimension, DimensionTweak.OVERWORLD_CONNECTION);
  }
}
