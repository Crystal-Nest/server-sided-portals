package it.crystalnest.server_sided_portals.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.permissions.PermissionLevel;
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
   * {@link GamemodeTweak} {@link Codec}.
   */
  public static final Codec<GamemodeTweak> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    GameType.CODEC.fieldOf("type").forGetter(GamemodeTweak::gamemode),
    Codec.INT.optionalFieldOf("permission", PermissionLevel.OWNERS.id() + 1).forGetter(GamemodeTweak::permission),
    Codec.STRING.listOf().optionalFieldOf("players", List.of()).forGetter(GamemodeTweak::players),
    Codec.STRING.listOf().optionalFieldOf("teams", List.of()).forGetter(GamemodeTweak::teams),
    Codec.BOOL.optionalFieldOf("whitelist", false).forGetter(GamemodeTweak::whitelist)
  ).apply(instance, (gamemode, permission, players, teams, whitelist) -> new GamemodeTweak(gamemode, new PermissionTweak(permission, players, teams, whitelist))));

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
}
