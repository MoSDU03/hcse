package com.example.hcse;

import com.example.hcse.components.CanvasManager;
import com.example.hcse.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LowCodeApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        StartScreen startScreen = new StartScreen();

        Scene startScene = startScreen.createScene(primaryStage, selectedType -> {
            if (selectedType.equalsIgnoreCase("Mobile app")) {
                // Modular routing to mobile-specific builder
                MobileBuilderScreen mobileBuilder = new MobileBuilderScreen();
                Scene mobileScene = mobileBuilder.createScene();
                primaryStage.setScene(mobileScene);
            } else {
                // Default builder route
                CanvasController controller = new CanvasController(selectedType);
                Scene builderScene = new Scene(controller.getCanvas(), 1000, 700);
                primaryStage.setScene(builderScene);
            }
        });

        primaryStage.setScene(startScene);
        primaryStage.setTitle("Low-Code Builder");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}