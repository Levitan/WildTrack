package xyz.wildapp.android.wildtrack.api.tools;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by vborisovskii on 4/3/18.
 */

public class Deserializer<T> implements JsonDeserializer<T> {

    private final String element;

    public Deserializer(String element) {
        this.element = element;
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement content = json.getAsJsonObject().get("data").getAsJsonObject().get(element);
        return new Gson().fromJson(content, typeOfT);
    }
}
