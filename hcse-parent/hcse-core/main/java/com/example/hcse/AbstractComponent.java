package com.example.hcse.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractComponent implements UIComponent {
    protected String id;
    protected String type;
    protected Map<String, Object> properties = new HashMap<>();
    protected List<UIComponent> children = new ArrayList<>();

    public AbstractComponent(String id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public List<UIComponent> getChildren() {
        return children;
    }
}