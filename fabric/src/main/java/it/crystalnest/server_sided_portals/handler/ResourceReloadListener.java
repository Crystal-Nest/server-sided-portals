package it.crystalnest.server_sided_portals.handler;

import it.crystalnest.server_sided_portals.Constants;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.Identifier;

/**
 * Resource (datapack) reload listener.
 */
public final class ResourceReloadListener extends CommonResourceReloadListener implements IdentifiableResourceReloadListener {
  @Override
  public Identifier getFabricId() {
    return Constants.DIMENSION_TWEAKS_ID;
  }
}
