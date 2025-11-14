package it.crystalnest.server_sided_portals.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

import java.lang.reflect.Type;
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
      player.server.getProfilePermissions(player.getGameProfile()) >= permission() ||
      players().stream().anyMatch(profile -> player.getStringUUID().equalsIgnoreCase(profile)) ||
      (player.getTeam() != null && teams().stream().anyMatch(team -> player.getTeam().getName().equals(team)))
    );
  }

  /**
   * {@link GamemodeTweak} {@link JsonDeserializer}.
   */
  public static class Deserializer implements JsonDeserializer<PermissionTweak> {
    @Override
    public PermissionTweak deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      JsonObject object = json.getAsJsonObject();
      return new PermissionTweak(
        object.has("permission") ? object.get("permission").getAsInt() : Commands.LEVEL_OWNERS + 1,
        object.has("players") ? context.deserialize(object.get("players"), new TypeToken<List<String>>() {}.getType()) : Collections.emptyList(),
        object.has("teams") ? context.deserialize(object.get("teams"), new TypeToken<List<String>>() {}.getType()) : Collections.emptyList(),
        object.has("whitelist") && object.get("whitelist").getAsBoolean()
      );
    }
  }
}
