package com.example.hcse.components;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ComponentSerializer {
    private static final Gson gson = new Gson();

    public static String serialize(Collection<UIComponent> components) {
        return gson.toJson(components);
    }

    public static List<UIComponent> deserialize(String json) {
        Type listType = new TypeToken<List<UIComponent>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
