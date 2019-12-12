package com.mainPack.gameStart;

import com.mainPack.gameLevel.GameFactory;
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

/**
 * Displays the start menu at the beginning of when the program is
 * run - Game information, level 1, level2 , exit
 */
public class StartMenu implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button level1Btn;
    private Button level2Btn;
    public Button exitBtn;
    private Button gameInfoBtn;
    private ImageView frogKing;
    private ImageView froggerTitle;
    private ImageView menuBackground;
    private Alert howToPlay;

    private static StartMenu instance;
    private static String filePath = "file:src/main/resources/";

    /**
     * Returns the instance if the object has already been created, otherwise
     * creates a new startMenu object and returns the instance
     * @param primaryStage
     * @return
     */
    public static StartMenu getInstance(Stage primaryStage){
        if(instance == null){
            instance = new StartMenu(primaryStage);
        }
        return instance;
    }

    /**
     * Constructor sets the primaryStage to the one passed into the function
     * and displays the starting menu
     * @param primaryStage
     */
    private StartMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.displayStart();


    }

    /**
     * Creates all the necessary JavaFX components, adds the images, buttons
     * and the CSS file before displaying to the user
     */
    public void displayStart(){
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
        scene.getStylesheets().add(filePath + "startScreenCustom.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Based on the action Performed for example, b"utton clicked", either a new level
     * is created, the game is exited or the information on how to play
     * the game is displayed to the user
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == level1Btn){
            //FirstLevel newLevel = new FirstLevel(this.primaryStage);
            GameFactory gamefac = new GameFactory(this.primaryStage);
            gamefac.newGame("1");
        }else if(event.getSource() == level2Btn){
            GameFactory gamefac = new GameFactory(this.primaryStage);
            gamefac.newGame("2");
        }
        else if(event.getSource() == exitBtn){
            primaryStage.close();
        }
        else if(event.getSource() == gameInfoBtn){
            //open the newbox with the information
            howToPlay = new Alert(Alert.AlertType.INFORMATION);
            customScreen();
            gameInfomation();
        }
    }

    /**
     * displays the information of how to play frogger
     * the game to the user
     */
    public void gameInfomation(){
        howToPlay.setHeight(600);
        howToPlay.setTitle("Game Information");
        howToPlay.setHeaderText("How to play Frogger");
        howToPlay.setContentText("This is how you play the game:\n" +
                "1) Use WASD to move up, left, down and right respectively.\n" +
                "2) Aim of the game is to get the frog to each square at the end of the map.\n" +
                "3) Points are gained from Moving further up the map and getting to each of the squares at the end\n" +
                "4) This is done by avoiding the trucks, cars and from falling in the water.\n" +
                "5) Turtles disappear every so often so be careful not to fall into the water and lose points.\n" +
                "6) At the end of the game a score will be displayed to the player which indicates the highest score reached.");
        howToPlay.showAndWait();
    }

    /**
     * adds all the CSS needed from the CSS file in the
     * resources
     */
    public void customScreen(){
        DialogPane customPane = howToPlay.getDialogPane();
        customPane.getStylesheets().add(filePath + "startScreenCustom.css");
        customPane.getStyleClass().add("dialogWriting");
        customPane.getStyleClass().add("Dialog");
        customPane.getStyleClass().add("dialogHeader");
        customPane.getStyleClass().add("dialogTopLabel");
    }

    /**
     * Sets the position of the buttons on the screen
     */
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

    /**
     * Creates the button objects and sets the text of each
     * button
     */
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

    /**
     * Creates the Images and sets the postion of the images for the
     * start screen background before it is added to the background in displayStart()
     */
    public void pictureCreation(){
        Image froggerTitlePic = new Image(filePath + "FroggerTitleStartScreen.png");
        froggerTitle = new ImageView(froggerTitlePic);
        froggerTitle.setTranslateY(-350);

        Image menuBackgroundPic = new Image(filePath + "StartScreenBackground.png");
        menuBackground = new ImageView(menuBackgroundPic);

        Image frogKingPic = new Image(filePath + "frogKing2.png");
        frogKing = new ImageView(frogKingPic);
    }
}
