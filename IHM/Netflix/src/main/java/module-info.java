module com.example.netflix {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.netflix to javafx.fxml;
    exports com.example.netflix;
}