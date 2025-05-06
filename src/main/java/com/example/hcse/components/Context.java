package com.example.hcse.components;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Object> state = new HashMap<>();

    public Object get(String key) {
        return state.get(key);
    }

    public void set(String key, Object value) {
        state.put(key, value);
    }
}