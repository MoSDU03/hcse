package com.example.hcse;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.components.DefaultComponentFactory;
import com.example.hcse.components.UIComponent;
import com.example.hcse.ui.CanvasArea;
import com.example.hcse.ui.Sidebar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LowCodeApp extends Application {
    private CanvasManager canvasManager;

    @Override
    public void start(Stage primaryStage) {
        canvasManager = new CanvasManager();
        DefaultComponentFactory factory = new DefaultComponentFactory();
        CanvasArea canvas = new CanvasArea(canvasManager);
        Sidebar sidebar = new Sidebar(factory, canvasManager, canvas);

        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Low-Code Tool Prototype");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}