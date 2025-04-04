package it.crystalnest.server_sided_portals.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import net.minecraft.commands.Commands;
import net.minecraft.world.level.GameType;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Tweak for changing players' type when entering a dimension.
 *
 * @param type type change.
 * @param permission permission level.
 * @param players list of UUIDs.
 * @param whitelist whether to use this tweak as a whitelist.
 */
public record GamemodeTweak(GameType type, int permission, List<String> players, boolean whitelist) {
  /**
   * {@link GamemodeTweak} {@link JsonDeserializer}.
   */
  public static class Deserializer implements JsonDeserializer<GamemodeTweak> {
    @Override
    public GamemodeTweak deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      JsonObject object = json.getAsJsonObject();
      return new GamemodeTweak(
        GameType.byName(object.get("type").getAsString()),
        object.has("permission") ? object.get("permission").getAsInt() : Commands.LEVEL_OWNERS + 1,
        object.has("players") ? context.deserialize(object.get("players"), new TypeToken<List<String>>() {}.getType()) : Collections.emptyList(),
        object.has("whitelist") && object.get("whitelist").getAsBoolean()
      );
    }
  }
}
