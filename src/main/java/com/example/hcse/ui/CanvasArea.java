package com.example.hcse.ui;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CanvasArea extends Pane {
    private final CanvasManager canvasManager;
    private int offsetY = 50;

    public CanvasArea(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
        this.setStyle("-fx-background-color: white; -fx-border-color: black;");
        this.setPrefSize(400, 400);
        this.setPickOnBounds(true);
        Rectangle debugBox = new Rectangle(375, 667);
        debugBox.setFill(Color.rgb(255, 255, 0, 0.2));
        this.getChildren().add(debugBox);
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
        label.setPrefSize(80, 30);
        label.setStyle("-fx-background-color: lightyellow; -fx-border-color: black;");
        enableDrag(label);
        this.getChildren().add(label);
        System.out.println("✅ Label added to canvas");
    }

    public void renderButtonAt(SetValueComponent component, double x, double y) {
        System.out.println("🖊 renderButtonAt: " + x + ", " + y);
        Button button = new Button("Set Value");
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(100, 40);
        button.setStyle("-fx-background-color: lightblue; -fx-border-color: black;");
        enableDrag(button);
        this.getChildren().add(button);
        System.out.println("✅ Button added to canvas. Total children: " + this.getChildren().size());
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
