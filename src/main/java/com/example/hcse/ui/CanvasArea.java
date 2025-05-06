package com.example.hcse.ui;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class CanvasArea extends Pane {
    private int offsetY = 50;
    private final CanvasManager canvasManager;

    public CanvasArea(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
        this.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;");
        this.setPrefSize(400, 400);
    }

    public void renderLabel(LabelComponent component) {
        String text = (String) component.getProperties().getOrDefault("text", "Label");
        Text label = new Text(50, offsetY, text);

        final double[] dragDelta = new double[2];
        label.setOnMousePressed(event -> {
            dragDelta[0] = event.getX() - label.getX();
            dragDelta[1] = event.getY() - label.getY();
            label.toFront();
        });

        label.setOnMouseDragged(event -> {
            label.setX(event.getX() - dragDelta[0]);
            label.setY(event.getY() - dragDelta[1]);
        });

        this.getChildren().add(label);
        offsetY += 30;
    }

    public void renderButton(SetValueComponent component) {
        Button button = new Button("Set Value");
        button.setLayoutX(50);
        button.setLayoutY(offsetY);

        final double[] dragDelta = new double[2];
        button.setOnMousePressed(event -> {
            dragDelta[0] = event.getX() - button.getLayoutX();
            dragDelta[1] = event.getY() - button.getLayoutY();
            button.toFront();
        });

        button.setOnMouseDragged(event -> {
            button.setLayoutX(event.getX() - dragDelta[0]);
            button.setLayoutY(event.getY() - dragDelta[1]);
        });

        this.getChildren().add(button);
        offsetY += 40;
    }
}