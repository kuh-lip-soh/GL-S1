package com.example.tpsnake;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private Pane cel;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}