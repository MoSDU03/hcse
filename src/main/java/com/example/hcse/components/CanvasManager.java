package com.example.hcse.components;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CanvasManager {
    private Map<String, UIComponent> components = new HashMap<>();

    public void addComponent(UIComponent component) {
        components.put(component.getId(), component);
    }

    public void removeComponent(String id) {
        components.remove(id);
    }

    public Collection<UIComponent> getComponents() {
        return components.values();
    }
}