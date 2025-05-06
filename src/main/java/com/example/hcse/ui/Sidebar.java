package com.example.hcse.ui;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.ComponentFactory;
import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;
import com.example.hcse.components.UIComponent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sidebar extends VBox {
    private int counter = 0;

    public Sidebar(ComponentFactory factory, CanvasManager manager, CanvasArea canvas) {
        this.setSpacing(10);
        this.setStyle("-fx-padding: 10; -fx-background-color: #e0e0e0;");

        Button btnLabel = new Button("Add Label");
        btnLabel.setOnAction(e -> {
            String id = "label" + (++counter);
            UIComponent component = factory.createComponent("label", id);
            manager.addComponent(component);
            if (component instanceof LabelComponent label) {
                canvas.renderLabel(label);
            }
        });

        Button btnButton = new Button("Add Button");
        btnButton.setOnAction(e -> {
            String id = "button" + (++counter);
            UIComponent component = factory.createComponent("setValue", id);
            manager.addComponent(component);
            if (component instanceof SetValueComponent logic) {
                canvas.renderButton(logic);
            }
        });

        this.getChildren().addAll(btnLabel, btnButton);
    }
}