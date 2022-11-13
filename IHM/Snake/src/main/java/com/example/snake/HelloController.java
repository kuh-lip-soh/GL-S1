package com.example.snake;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void FoodGen() {
        int i=(int)(Math.random()*20);
        int j=(int)(Math.random()*20);
}

}