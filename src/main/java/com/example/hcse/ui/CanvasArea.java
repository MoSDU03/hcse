package com.example.hcse.ui;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CanvasArea extends Pane {
    private final CanvasManager canvasManager;
    private int offsetY = 50;

    public CanvasArea(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
        this.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;");
        this.setPrefSize(400, 400);
        this.setPickOnBounds(true); // Ensure it can receive mouse events

    }

    // For CanvasController (default placement)
    public void renderLabel(LabelComponent component) {
        Label label = new Label((String) component.getProperties().getOrDefault("text", "Label"));
        label.setLayoutX(50);
        label.setLayoutY(offsetY);
        enableDrag(label);
        this.getChildren().add(label);
        offsetY += 30;
        System.out.println("🧩 Added label at default Y: " + offsetY);
    }

    public void renderButton(SetValueComponent component) {
        Button button = new Button("Set Value");
        button.setLayoutX(50);
        button.setLayoutY(offsetY);
        enableDrag(button);
        this.getChildren().add(button);
        offsetY += 40;
        System.out.println("🧩 Added button at default Y: " + offsetY);
    }

    // For drag-and-drop (dynamic placement)
    public void renderLabelAt(LabelComponent component, double x, double y) {
        System.out.println("🖊 renderLabelAt: " + x + ", " + y);
        Label label = new Label((String) component.getProperties().getOrDefault("text", "Label"));
        label.setLayoutX(x);
        label.setLayoutY(y);
        enableDrag(label);
        this.getChildren().add(label);
    }

    public void renderButtonAt(SetValueComponent component, double x, double y) {
        System.out.println("🖊 renderButtonAt: " + x + ", " + y);
        Button button = new Button("Set Value");
        button.setLayoutX(x);
        button.setLayoutY(y);
        enableDrag(button);
        this.getChildren().add(button);
    }

    private void enableDrag(Node node) {
        final double[] dragDelta = new double[2];

        node.setOnMousePressed(event -> {
            dragDelta[0] = event.getX();
            dragDelta[1] = event.getY();
            node.toFront();
        });

        node.setOnMouseDragged(event -> {
            node.setLayoutX(event.getSceneX() - dragDelta[0]);
            node.setLayoutY(event.getSceneY() - dragDelta[1]);
        });
    }
}
