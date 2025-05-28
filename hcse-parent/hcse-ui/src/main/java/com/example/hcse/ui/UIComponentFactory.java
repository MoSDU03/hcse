package com.example.hcse.ui;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class UIComponentFactory {
    public static Text createLabel(int y) {
        return new Text(50, y, "New Label");
    }

    public static Button createButton(int y) {
        Button button = new Button("Click Me");
        button.setLayoutX(50);
        button.setLayoutY(y);
        return button;
    }
}