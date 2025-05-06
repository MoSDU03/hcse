module com.example.hcse {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.hcse to javafx.fxml;
    exports com.example.hcse;
}