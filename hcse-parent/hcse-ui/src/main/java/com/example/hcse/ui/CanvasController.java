package com.example.hcse.ui;


import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;

public class CanvasController {
    private final CanvasManager manager;
    private final CanvasArea canvas;

    public CanvasController(String appType) {
        this.manager = new CanvasManager();
        this.canvas = new CanvasArea(manager);
        setupInitialComponents(appType);
    }

    private void setupInitialComponents(String appType) {
        LabelComponent label = new LabelComponent("label1");
        label.getProperties().put("text", "Welcome to your " + appType);
        manager.addComponent(label);
        canvas.renderLabel(label);

        SetValueComponent button = new SetValueComponent("button1");
        manager.addComponent(button);
        canvas.renderButton(button);
    }

    public CanvasArea getCanvas() {
        return canvas;
    }

    public CanvasManager getManager() {
        return manager;
    }

}
