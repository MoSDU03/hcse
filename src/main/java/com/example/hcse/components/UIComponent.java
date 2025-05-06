package com.example.hcse.components;

import java.util.List;
import java.util.Map;

public interface UIComponent {
    String getId();
    String getType();
    Map<String, Object> getProperties();
    List<UIComponent> getChildren();
}
