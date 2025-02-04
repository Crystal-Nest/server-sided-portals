package it.crystalnest.server_sided_portals.mixin;

import it.crystalnest.server_sided_portals.command.Test;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerLevel.class)
public class TestMixin implements Test {
  @Final
  @Shadow
  private ServerLevelData serverLevelData;

  @Override
  public ServerLevelData getLevelData() {
    return serverLevelData;
  }
}
