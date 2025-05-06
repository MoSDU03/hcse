package com.example.hcse.components;

public class LabelComponent extends AbstractComponent {
    public LabelComponent(String id) {
        super(id, "label");
        properties.put("text", "Default Label");
    }
}