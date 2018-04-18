package xyz.wildapp.android.wildtrack.api.tools;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by vborisovskii on 4/18/18.
 */

public class Serializer<T> implements JsonSerializer<T> {
    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject tracking = new JsonObject();
        JsonParser parser = new JsonParser();
        JsonElement child = parser.parse(new Gson().toJson(src));
        tracking.add("tracking", child);
        return tracking;
    }
}