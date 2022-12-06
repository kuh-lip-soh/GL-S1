package com.example.netflix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    public void goToYourName(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("your name.fxml"));
        Scene scene = new Scene(fx.load(), 854, 480);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fx.load(), 854, 480);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}