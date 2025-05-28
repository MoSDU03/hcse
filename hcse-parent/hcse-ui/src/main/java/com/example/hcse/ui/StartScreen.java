package com.example.hcse.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.function.Consumer;

public class StartScreen {
    private final ToggleGroup toggleGroup = new ToggleGroup();

    public Scene createScene(Stage stage, Consumer<String> onContinue) {
        VBox root = new VBox(30);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.TOP_CENTER);

        Label title = new Label("What would you like to create?");
        title.setFont(Font.font("System", FontWeight.BOLD, 24));

        HBox options = new HBox(20);
        options.setAlignment(Pos.CENTER);

        ToggleButton webBtn = createCard("Web app", "Responsive interface...");
        ToggleButton mobileBtn = createCard("Mobile app", "Optimized for phones...");
        ToggleButton agentBtn = createCard("Agent", "AI-driven logic...");

        options.getChildren().addAll(webBtn, mobileBtn, agentBtn);

        Button helpBtn = new Button("Help");
        helpBtn.setOnAction(e -> HelpDialog.showHelp()); // Modular popup logic

        HBox bottom = new HBox(10);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        Button backBtn = new Button("Go back");
        Button continueBtn = new Button("Continue");

        continueBtn.setOnAction(e -> {
            Toggle selected = toggleGroup.getSelectedToggle();
            if (selected != null) {
                String selectedType = selected.getUserData().toString();
                onContinue.accept(selectedType);
            }
        });

        bottom.getChildren().addAll(backBtn, continueBtn);

        root.getChildren().addAll(title, options, helpBtn, bottom);

        return new Scene(root, 700, 500);
    }

    private ToggleButton createCard(String title, String description) {
        ToggleButton button = new ToggleButton(title + "\n\n" + description);
        button.setMinSize(180, 180);
        button.setToggleGroup(toggleGroup);
        button.setUserData(title);
        return button;
    }

}