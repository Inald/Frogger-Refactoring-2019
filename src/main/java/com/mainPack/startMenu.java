package com.mainPack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class startMenu extends Levels implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button startBtn;
    private Button exitBtn;
    private Button gameInfoBtn;
    private ImageView view;

    public startMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;

        buttonCreation();

        StackPane screenLayout = new StackPane();
        screenLayout.getChildren().add(startBtn);
        screenLayout.getChildren().add(exitBtn);
        screenLayout.getChildren().add(gameInfoBtn);

        pictureCreation();
        screenLayout.getChildren().add(view);

        buttonTranslation();


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
        else if(event.getSource() == gameInfoBtn){
            //open the newbox with the information
        }
    }

    public void buttonTranslation(){
        //translation of start Button
        startBtn.setTranslateY(300);
        //translation of exit button
        exitBtn.setTranslateY(300);
        exitBtn.setTranslateX(200);
        //translation of game info button
        gameInfoBtn.setTranslateX(-200);
        gameInfoBtn.setTranslateY(300);
    }

    public void buttonCreation(){
        startBtn = new Button();
        startBtn.setText("Start Game");
        startBtn.setOnAction(this);

        exitBtn = new Button();
        exitBtn.setText("Exit");
        exitBtn.setOnAction(this);

        gameInfoBtn = new Button();
        gameInfoBtn.setText("Game information");
        gameInfoBtn.setOnAction(this);
    }

    public void pictureCreation(){
        Image smilingFrog = new Image("greenCartoonFrogReSized.jpg");
        view = new ImageView(smilingFrog);
    }
}
