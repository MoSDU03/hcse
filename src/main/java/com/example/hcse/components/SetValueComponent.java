package com.example.hcse.components;

public class SetValueComponent extends AbstractComponent implements ExecutableComponent {
    public SetValueComponent(String id) {
        super(id, "setValue");
    }

    @Override
    public void execute(Context context) {
        String key = (String) properties.get("key");
        Object value = properties.get("value");
        context.set(key, value);
    }
}
