package it.crystalnest.server_sided_portals.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.Commands;
import net.minecraft.world.level.GameType;

import java.util.List;

/**
 * Tweak for changing players' gamemode when entering a dimension.
 *
 * @param gamemode gamemode change.
 * @param permissionTweak {@link PermissionTweak}.
 */
public record GamemodeTweak(GameType gamemode, PermissionTweak permissionTweak) {
  /**
   * permission level.
   */
  public int permission() {
    return permissionTweak().permission();
  }

  /**
   * list of UUIDs.
   */
  public List<String> players() {
    return permissionTweak().players();
  }

  /**
   * teams the player belongs to.
   */
  public List<String> teams() {
    return permissionTweak().teams();
  }

  /**
   * whether to use this tweak as a whitelist.
   */
  public boolean whitelist() {
    return permissionTweak().whitelist();
  }

  /**
   * {@link GamemodeTweak} {@link Codec}.
   */
  public static final Codec<GamemodeTweak> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    GameType.CODEC.fieldOf("type").forGetter(GamemodeTweak::gamemode),
    Codec.INT.optionalFieldOf("permission", Commands.LEVEL_OWNERS + 1).forGetter(GamemodeTweak::permission),
    Codec.STRING.listOf().optionalFieldOf("players", List.of()).forGetter(GamemodeTweak::profiles),
    Codec.BOOL.optionalFieldOf("whitelist", false).forGetter(GamemodeTweak::whitelist)
  ).apply(instance, GamemodeTweak::new));
}
