package it.crystalnest.server_sided_portals.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.world.level.GameType;

import java.lang.reflect.Type;
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
   * {@link GamemodeTweak} {@link JsonDeserializer}.
   */
  public static class Deserializer implements JsonDeserializer<GamemodeTweak> {
    @Override
    public GamemodeTweak deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      return new GamemodeTweak(GameType.byName(json.getAsJsonObject().get("type").getAsString()), new PermissionTweak.Deserializer().deserialize(json, typeOfT, context));
    }
  }
}
