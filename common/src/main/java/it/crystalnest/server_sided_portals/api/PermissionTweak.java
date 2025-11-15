package it.crystalnest.server_sided_portals.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collections;
import java.util.List;

/**
 * Tweak for applying a tweak or allowing dimension change when trying to enter a dimension.
 *
 * @param permission permission level.
 * @param players list of UUIDs.
 * @param teams teams the player belongs to.
 * @param whitelist whether to use this tweak as a whitelist.
 */
public record PermissionTweak(int permission, List<String> players, List<String> teams, boolean whitelist) {
  /**
   * {@link GamemodeTweak} {@link Codec}.
   */
  public static final Codec<PermissionTweak> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    Codec.INT.optionalFieldOf("permission", Commands.LEVEL_OWNERS + 1).forGetter(PermissionTweak::permission),
    Codec.STRING.listOf().optionalFieldOf("players", List.of()).forGetter(PermissionTweak::players),
    Codec.STRING.listOf().optionalFieldOf("teams", List.of()).forGetter(PermissionTweak::teams),
    Codec.BOOL.optionalFieldOf("whitelist", false).forGetter(PermissionTweak::whitelist)
  ).apply(instance, PermissionTweak::new));

  /**
   * Default permission tweak that allows any player.
   */
  public static final PermissionTweak DEFAULT_PERMISSION = new PermissionTweak(Commands.LEVEL_OWNERS + 1, Collections.emptyList(), Collections.emptyList(), false);

  /**
   * Checks whether the given player is allowed (can travel / the tweak applies).
   *
   * @param player player.
   * @return whether the player is included by this permission.
   */
  public boolean isAllowed(ServerPlayer player) {
    return whitelist() == (
      player.getPermissionLevel() >= permission() ||
      players().stream().anyMatch(profile -> player.getStringUUID().equalsIgnoreCase(profile)) ||
      (player.getTeam() != null && teams().stream().anyMatch(team -> player.getTeam().getName().equals(team)))
    );
  }
}
