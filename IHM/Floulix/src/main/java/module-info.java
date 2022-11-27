module com.example.floulix {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.floulix to javafx.fxml;
    exports com.example.floulix;
}