package com.zte.sunquan.demo.serialize;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by 10184538 on 2017/2/21.
 */
public class Device implements Node,JsonDeserializer<Node> {
    private String name;
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Node deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (json.isJsonObject()) {
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.get("name") != null) {
                Device device = new Device();
                device.setName(jsonObject.get("name").getAsString());
                return device;
            }
        }
        return null;
    }
}
