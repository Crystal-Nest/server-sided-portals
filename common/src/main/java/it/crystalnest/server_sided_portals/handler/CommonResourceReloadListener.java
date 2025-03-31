package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import it.crystalnest.server_sided_portals.api.DimensionTweak;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Handler for resource reload events.
 */
public class CommonResourceReloadListener extends SimpleJsonResourceReloadListener<List<DimensionTweak>> {
  protected CommonResourceReloadListener() {
    super(DimensionTweak.CODEC.listOf(), FileToIdConverter.json(Constants.DIMENSION_TWEAKS_ID.getPath()));
  }

  @Override
  protected void apply(Map<ResourceLocation, List<DimensionTweak>> datamap, @NotNull ResourceManager manager, @NotNull ProfilerFiller profiler) {
    Constants.DIMENSION_TWEAKS.clear();
    for (List<DimensionTweak> tweaks : datamap.values()) {
      for (DimensionTweak tweak : tweaks) {
        Constants.DIMENSION_TWEAKS.put(tweak.dimension(), tweak);
      }
    }
  }
}
