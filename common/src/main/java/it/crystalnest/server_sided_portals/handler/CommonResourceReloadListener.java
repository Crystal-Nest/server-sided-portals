package it.crystalnest.server_sided_portals.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import it.crystalnest.server_sided_portals.Constants;
import it.crystalnest.server_sided_portals.api.DimensionTweak;
import it.crystalnest.server_sided_portals.api.GamemodeTweak;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Handler for resource reload events.
 */
public class CommonResourceReloadListener extends SimpleJsonResourceReloadListener {
  /**
   * Reusable {@link Gson} with {@link ResourceKey} parsing ability.
   */
  private final Gson gson;

  /**
   * JSON {@link TypeToken} for a list of {@link DimensionTweak}s.
   */
  private final Type tweakListType = new TypeToken<List<DimensionTweak>>() {}.getType();

  protected CommonResourceReloadListener() {
    super(new Gson(), Constants.DIMENSION_TWEAKS_ID.getPath());
    gson = new GsonBuilder()
      .registerTypeAdapter(new TypeToken<ResourceKey<Level>>() {}.getType(), new ResourceKeyDeserializer())
      .registerTypeAdapter(GamemodeTweak.class, new GamemodeTweak.Deserializer())
      .create();
  }

  @Override
  protected void apply(Map<ResourceLocation, JsonElement> datamap, @NotNull ResourceManager manager, @NotNull ProfilerFiller profiler) {
    Constants.DIMENSION_TWEAKS.clear();
    for (Map.Entry<ResourceLocation, JsonElement> entry : datamap.entrySet()) {
      try {
        List<DimensionTweak> tweaks = gson.fromJson(entry.getValue(), tweakListType);
        for (DimensionTweak tweak : tweaks) {
          Constants.DIMENSION_TWEAKS.put(tweak.dimension(), tweak);
        }
      } catch (JsonSyntaxException e) {
        Constants.LOGGER.error("Error parsing {} dimension tweaks!", entry.getKey(), e);
      }
    }
  }

  /**
   * {@link ResourceKey} {@link JsonDeserializer}.
   */
  public static class ResourceKeyDeserializer implements JsonDeserializer<ResourceKey<Level>> {
    @Override
    public ResourceKey<Level> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      return ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(json.getAsString()));
    }
  }
}
