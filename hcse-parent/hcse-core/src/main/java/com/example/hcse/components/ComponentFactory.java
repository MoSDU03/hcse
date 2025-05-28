package com.example.hcse.components;

public interface ComponentFactory {
    UIComponent createComponent(String type, String id);
}