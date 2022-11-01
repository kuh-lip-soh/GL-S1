module com.mycompany.tp3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tp3 to javafx.fxml;
    exports com.mycompany.tp3;
}
