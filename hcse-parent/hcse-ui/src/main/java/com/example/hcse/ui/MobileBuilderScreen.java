package com.example.hcse.ui;

import com.example.hcse.components.*;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MobileBuilderScreen {

    private final CanvasManager canvasManager = new CanvasManager();
    private final ComponentFactory factory = new DefaultComponentFactory();

    public Scene createScene() {
        BorderPane root = new BorderPane();

        // Canvas
        CanvasArea canvas = new CanvasArea(canvasManager);
        canvas.setPrefSize(375, 667);
        canvas.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #333; -fx-border-width: 2px;");

        Pane phoneFrame = new Pane(canvas);
        phoneFrame.setPadding(new Insets(20));
        phoneFrame.setStyle("-fx-background-color: #dcdcdc;");
        phoneFrame.setPrefSize(415, 707);


        // Sidebar
        VBox toolbox = new VBox(15);
        toolbox.setPadding(new Insets(20));
        toolbox.setAlignment(Pos.TOP_CENTER);
        toolbox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc;");
        toolbox.setPrefWidth(200);

        Label header = new Label("Components");
        header.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label draggableLabel = new Label("Label");
        Label draggableButton = new Label("Button");

        setupDrag(draggableLabel, "Label");
        setupDrag(draggableButton, "SetValue");

        toolbox.getChildren().addAll(header, draggableLabel, draggableButton);

        root.setLeft(phoneFrame);
        root.setRight(toolbox);

        setupDrop(canvas);

        return new Scene(root, 1000, 700);
    }

    private void setupDrag(Label item, String componentType) {
        item.setOnDragDetected(event -> {
            Dragboard db = item.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(componentType);
            db.setContent(content);
            db.setDragView(item.snapshot(null, null));
            item.setFocusTraversable(true);
            System.out.println("✅ Drag started: " + componentType);
            event.consume();
        });
    }

    private void setupDrop(CanvasArea canvas) {
        canvas.setOnDragOver(event -> {
            System.out.println("🎯 DragOver detected");
            if (event.getGestureSource() != canvas && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        canvas.setOnDragDropped(event -> {
            System.out.println("🧲 Drop event detected!");
            Dragboard db = event.getDragboard();
            boolean success = false;

            try {
                if (db.hasString()) {
                    String type = db.getString();
                    System.out.println("📥 Drop received: " + type);

                    String id = type.toLowerCase() + "_" + System.currentTimeMillis();
                    UIComponent component = factory.createComponent(type, id);
                    canvasManager.addComponent(component);

                    Point2D localPoint = canvas.sceneToLocal(event.getSceneX(), event.getSceneY());
                    System.out.println("🧭 Local drop coordinates: " + localPoint);

                    double x = Math.max(10, Math.min(localPoint.getX(), canvas.getWidth() - 100));
                    double y = Math.max(10, Math.min(localPoint.getY(), canvas.getHeight() - 30));

                    if (component instanceof LabelComponent label) {
                        label.getProperties().put("text", "Label");
                        canvas.renderLabelAt(label, x, y);
                    } else if (component instanceof SetValueComponent button) {
                        canvas.renderButtonAt(button, x, y);
                    }

                    success = true;
                }
            } catch (Exception ex) {
                System.out.println("❌ Exception during drop: " + ex.getMessage());
                ex.printStackTrace();
            }

            event.setDropCompleted(success);
            event.consume();
        });

    }
}
