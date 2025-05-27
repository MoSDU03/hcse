package com.example.hcse.components;

public class DefaultComponentFactory implements ComponentFactory {
    @Override
    public UIComponent createComponent(String type, String id) {
        return switch (type.toLowerCase()) {  // ✅ Normalize input
            case "label" -> new LabelComponent(id);
            case "setvalue" -> new SetValueComponent(id);
            default -> throw new IllegalArgumentException("Unknown component type: " + type);
        };
    }
}
