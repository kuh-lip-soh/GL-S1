package com.example.tpsnake;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

public class HelloApplication extends Application {
    private Pane root;
    private Circle food;
    private Random foodPos;
    private snakeEX snake;
    double i=120;
    private Text score;

    private boolean mange(){
        return food.intersects(snake.getBoundsInLocal());
    }
    public void generateFood()
    {
        food=new Circle(foodPos.nextInt(800),foodPos.nextInt(600),15);
        food.setFill(Color.GREEN);
        root.getChildren().add(food);

    }
    public void generateSnake()
    {
        snake=new snakeEX(400,300,17);
        root.getChildren().add(snake);
    }

public void move(){
    Platform.runLater(()->{snake.step();
    if(mange()){
        snake.Nouriture(food);
        score.setText(""+snake.getlength());
        generateFood();
    }
    else if(gameover())
    {
        root.getChildren().clear();
        root.getChildren().add(score);
        score.setText("Game over, your score is "+ snake.getlength());
        generateSnake();
        generateFood();
    }

    });
}
private boolean gameover(){
        return snake.eatself() || snake.border();
}
    @Override
    public void start(Stage stage) throws IOException {
       root=new Pane();
       root.setPrefSize(800,600);
        foodPos=new Random();
        score=new Text(0,32,"0");
        generateFood();
        generateSnake();

        Runnable r=() ->{
            try {
                for (; ;) {
                    move();
                    Thread.sleep((long) i);
                    if(i>40)
                    i--;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };
        Scene scene = new Scene(root);
        scene.addEventFilter(KeyEvent.KEY_PRESSED,event -> {
            KeyCode code=event.getCode();
            if(code==KeyCode.UP)
                snake.setDirection(Direction.UP);
            else if(code==KeyCode.DOWN)
                snake.setDirection(Direction.DOWN);
            else if(code==KeyCode.LEFT)
                snake.setDirection(Direction.LEFT);
            else if(code==KeyCode.RIGHT)
                snake.setDirection(Direction.RIGHT);


        });
        stage.setTitle("Solid Snake");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        Thread th=new Thread(r);
        th.setDaemon(true);
        th.start();
    }

    public static void main(String[] args) {
        launch();
    }
}