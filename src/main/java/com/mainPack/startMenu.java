package com.mainPack;

import gameLevel.Levels;
import gameLevel.firstLevel;
import gameLevel.gameFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class startMenu implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button level1Btn;
    private Button level2Btn;
    private Button exitBtn;
    private Button gameInfoBtn;
    private ImageView frogKing;
    private ImageView froggerTitle;
    private ImageView menuBackground;

    public startMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Frogger start menu");

        buttonCreation();

        StackPane screenLayout = new StackPane();

        pictureCreation();
        screenLayout.getChildren().add(menuBackground);
        screenLayout.getChildren().add(froggerTitle);
        screenLayout.getChildren().add(frogKing);

        screenLayout.getChildren().add(level1Btn);
        screenLayout.getChildren().add(level2Btn);
        screenLayout.getChildren().add(exitBtn);
        screenLayout.getChildren().add(gameInfoBtn);

        buttonTranslation();


        Scene scene = new Scene(screenLayout, 600, 800);
        scene.getStylesheets().add("startScreenCustom.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == level1Btn){
            //firstLevel newLevel = new firstLevel(this.primaryStage);
            gameFactory gamefac = new gameFactory(this.primaryStage);
            gamefac.newGame("1");
        }else if(event.getSource() == level2Btn){
            gameFactory gamefac = new gameFactory(this.primaryStage);
            gamefac.newGame("2");
        }
        else if(event.getSource() == exitBtn){
            primaryStage.close();
        }
        else if(event.getSource() == gameInfoBtn){
            //open the newbox with the information
            Alert howToPlay = new Alert(Alert.AlertType.INFORMATION);
            DialogPane customPane = howToPlay.getDialogPane();
            customPane.getStylesheets().add("startScreenCustom.css");
            customPane.getStyleClass().add("dialogWriting");
            customPane.getStyleClass().add("Dialog");
            customPane.getStyleClass().add("dialogHeader");
            customPane.getStyleClass().add("dialogTopLabel");
            howToPlay.setHeight(600);
            howToPlay.setTitle("Game Information");
            howToPlay.setHeaderText("How to play Frogger");
            howToPlay.setContentText("This is how you play the game:\n" +
                    "1) Use WASD to move up, left, down and right respectively.\n" +
                    "2) Aim of the game is to get the frog to each square at the end of the map.\n" +
                    "3) Points are gained from moving further up the map and getting to each of the squares at the end\n" +
                    "4) This is done by avoiding the trucks, cars and from falling in the water.\n" +
                    "5) Turtles disappear every so often so be careful not to fall into the water and lose points.\n" +
                    "6) At the end of the game a score will be displayed to the player which indicates the highest score reached.");
            howToPlay.showAndWait();
        }
    }

    public void buttonTranslation(){
        //translation of level 1 Button
        level1Btn.setTranslateY(350);
        //translation of level 2 Button
        level2Btn.setTranslateX(100);
        level2Btn.setTranslateY(350);
        //translation of exit button
        exitBtn.setTranslateY(350);
        exitBtn.setTranslateX(200);
        //translation of game info button
        gameInfoBtn.setTranslateX(-150);
        gameInfoBtn.setTranslateY(350);
    }

    public void buttonCreation(){
        level1Btn = new Button();
        level1Btn.setText("level 1");
        level1Btn.setOnAction(this);

        level2Btn = new Button();
        level2Btn.setText("level 2");
        level2Btn.setOnAction(this);

        exitBtn = new Button();
        exitBtn.setText("Exit");
        exitBtn.setOnAction(this);

        gameInfoBtn = new Button();
        gameInfoBtn.setText("Game information");
        gameInfoBtn.setOnAction(this);

    }

    public void pictureCreation(){
        Image froggerTitlePic = new Image("FroggerTitleStartScreen.png");
        froggerTitle = new ImageView(froggerTitlePic);
        froggerTitle.setTranslateY(-350);

        Image menuBackgroundPic = new Image("StartScreenBackground.png");
        menuBackground = new ImageView(menuBackgroundPic);

        Image frogKingPic = new Image("frogKing2.png");
        frogKing = new ImageView(frogKingPic);
    }
}
