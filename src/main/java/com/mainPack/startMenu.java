package com.mainPack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class startMenu extends Levels implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button startBtn;
    private Button exitBtn;

    public startMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        startBtn = new Button();
        startBtn.setText("Start Game");
        startBtn.setOnAction(this);
        exitBtn = new Button();
        exitBtn.setText("Exit");
        exitBtn.setOnAction(this);


        StackPane screenLayout = new StackPane();
        screenLayout.getChildren().add(startBtn);


        Scene scene = new Scene(screenLayout, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == startBtn){
            firstLevel newLevel = new firstLevel(this.primaryStage);
        }
        else if(event.getSource() == exitBtn){
            primaryStage.close();
        }
    }
}
