module com.example.tpsnake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tpsnake to javafx.fxml;
    exports com.example.tpsnake;
}