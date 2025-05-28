package com.example.hcse.ui;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class HelpDialog {
    public static void showHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Getting Started");
        alert.setHeaderText("How to continue:");
        alert.setContentText(
                "Choose the type of application you want to create (Web, Mobile, or Agent).\n" +
                        "Then click 'Continue' to proceed to the visual builder.\n\n" +
                        "You can drag and drop components and create app logic in the next step."
        );
        alert.showAndWait();
    }

}
