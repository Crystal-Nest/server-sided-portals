package it.crystalnest.server_sided_portals.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.lang.reflect.Type;
import java.util.Collections;
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

  /**
   * {@link DimensionTweak} {@link JsonDeserializer}.
   */
  public static class Deserializer implements JsonDeserializer<DimensionTweak> {
    @Override
    public DimensionTweak deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      JsonObject object = json.getAsJsonObject();
      return new DimensionTweak(
        ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(object.get("dimension").getAsString())),
        object.has("connection") ? ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(object.get("connection").getAsString())) : Level.OVERWORLD,
        object.has("gamemode") ? context.deserialize(object.get("gamemode"), new TypeToken<List<GamemodeTweak>>() {}.getType()) : Collections.emptyList()
      );
    }
  }
}
