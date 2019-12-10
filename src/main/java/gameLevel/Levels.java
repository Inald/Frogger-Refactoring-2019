package gameLevel;


import com.mainPack.*;
import com.mainPack.froggerGameObstacles.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Abstract class which contains the implementation of levels.
 * Classes which extend Levels can use this class or override
 * methods to create new levels
 */
public abstract class Levels implements LevelStructure {
    private AnimationTimer timer;
    private MyStage background;
    private Animal animal;
    /**
     * Set to the stage passed into the Levels
     * constructor
     */
    private Stage primaryStage;
    protected String highScoreFile;

    /**
     * file path used to specify the resources needed to
     * display to the user
     */
    protected String filePath = "file:src/main/resources";

    /**
     * file path used to read and write to files for highScores at
     * the end of either level
     */
    protected String filePath2 = "src/main/resources/";
    protected Scene scene;

    /**
     * ArrayList used to stored the highScores to display to
     * the user
     */
    ArrayList<Integer> highScorePrint = new ArrayList<>();

    /**
     * Object of type FactoryMoving, uses getObject to add
     * the images to the background
     */
    FactoryMoving objFac = new FactoryMoving();

    /**
     * Constant used to set the right object type needed
     * for the factory class to display the object specified
     * by its name
     */
    private static final String LOG = "LOG";

    /**
     * Constant used to set the right object type needed
     * for the factory class to display the object specified
     * by its name
     */
    private static final String OBSTACLE = "OBSTACLE";

    /**
     * Constant used to set the right object type needed
     * for the factory class to display the object specified
     * by its name
     */
    private static final String TURTLE = "TURTLE";

    /**
     * Constant used to set the right object type needed
     * for the factory class to display the object specified
     * by its name
     */
    private static final String WETTURTLE = "WETTURTLE";

    /**
     * Constructor sets the value of primaryStage passed in, to the global
     * primaryStage value
     * @param primaryStage
     */
    public Levels(Stage primaryStage){
        this.primaryStage = primaryStage;

    }

    /**
     * Sets the new background based on the primaryStage, creates a new Scene to add
     * the background to and displays the number of frogger lives to begin with.
     */
    public void instantiateBackground(){
        setBackground(new MyStage());
        scene = new Scene(getBackground(), 600, 800);
        BackgroundImage froggerback = BackgroundImage.getInstance(filePath + "/iKogsKw3.png");

        getBackground().add(froggerback);
        getBackground().add(new Digit(3, 50, 328, 748));

    }

    public void createTimer() {
        //highScoreFile = filePath + "";
        //ArrayList<Integer> highScorePrint = new ArrayList<>();
        setTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (getAnimal().changeScore()) {
                    setNumber(getAnimal().getPoints());
                    setFroggerLives(getAnimal().getFrogLives());
                }
                if (getAnimal().getStop()) {
                    System.out.print("STOPP:");
                    getBackground().stopMusic();
                    stop();
                    getBackground().stop();

                    HighScoreRW RW = HighScoreRW.getInstance(primaryStage, getAnimal().getPoints(), highScoreFile);
                    highScorePrint = RW.highScores();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    DialogPane customPane = alert.getDialogPane();
                    customPane.getStylesheets().add(filePath + "/startScreenCustom.css");
                    customPane.getStyleClass().add("dialogWriting");
                    customPane.getStyleClass().add("Dialog");
                    customPane.getStyleClass().add("dialogHeader");
                    customPane.getStyleClass().add("dialogTopLabel");
                    alert.setHeight(600);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ getAnimal().getPoints()+"!");


                    StringBuffer stringBuf = new StringBuffer();
                    for(int j = highScorePrint.size() - 1; j > 0; j--){
                        stringBuf.append(String.valueOf(highScorePrint.get(j)) + "\n");
                    }

                    alert.setContentText("Highest Possible Score: 800\n" +
                            "High scores achieved by players:\n" +
                            stringBuf);


                    alert.show();
                    StartMenu backToStart = StartMenu.getInstance(primaryStage);
                    backToStart.displayStart();
                }
            }
        });
    }

    /**
     * This function plays the music in the background of the game and creates a
     * new timer for the duration of the game till the game ends
     */
    public void start() {
        getBackground().playMusic();
        createTimer();
        getTimer().start();
    }

    /**
     * Stops the timer running
     */
    public void stop() {
        getTimer().stop();
    }

    /**
     * Sets the score value for the number of frogger lives at the bottom of the screen based
     * on the number of lives left
     * @param n
     */
    public void setFroggerLives(int n){
       getBackground().add(new Digit(n,50, 328, 748));
    }

    /**
     * Alters the users score in the top left by shifting the score depending on
     * the number of digits e.g. 0 points, 10 points or 100 points
     * @param n
     */
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            getBackground().add(new Digit(k, 30, 565 - shift, 25));
            shift+=30;
        }
    }

    /**
     * Sets the users score in the top left
     */
    public void setScore(){
        getBackground().add(new Digit(0, 30, 565, 25));
    }

    public AnimationTimer getTimer() {
        return timer;
    }

    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }

    public MyStage getBackground() {
        return background;
    }

    public void setBackground(MyStage background) {
        this.background = background;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * Sets the Ends of the game by creating multiple end objects
     * and adds them to the background
     */
    public void setEnds(){
        getBackground().add(new End(13,96));
        getBackground().add(new End(141,96));
        getBackground().add(new End(141 + 141-13,96));
        getBackground().add(new End(141 + 141-13+141-13+1,96));
        getBackground().add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    /**
     * Instantiates a new frog and adds it to the background
     */
    public void setFrog(){
        setAnimal(new Animal(filePath + "/froggerUp.png"));
        getBackground().add(getAnimal());
    }

    /**
     * Sets the obstacles that will be present in the game by using the
     * FactoryMoving class to create the objects.
     */
    public void setLogs(){
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(objFac.getObject(LOG,filePath + "/logs.png", 300, 0, 276, -2));
        getBackground().add(objFac.getObject(LOG,filePath + "/logs.png", 300, 400, 276, -2));

        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 50, 329, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 490, 329, 0.75));
    }

    /**
     * Sets the Turtles that will be present in the game by using the
     * FactoryMoving class to create the objects.
     */
    public void setTurtle(){
        getBackground().add(objFac.getObject(TURTLE,"",500, 376, -1, 130, 130));
        getBackground().add(objFac.getObject(TURTLE, "",300, 376, -1, 130, 130));
    }

    /**
     * Sets the Wet Turtles that will be present in the game by using the
     * FactoryMoving class to create the objects.
     */
    public void setWetTurtle(){
        getBackground().add(objFac.getObject(WETTURTLE, "", 700, 376, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE,"",600, 217, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE,"",400, 217, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE,"",200, 217, -1, 130, 130));
    }

    /**
     * Sets the obstacles that will be present in the game by using the
     * FactoryMoving class to create the objects.
     */
    public void setObstacle(){
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck1"+"Right.png", 0, 649, 1, 120, 120));
        getBackground().add(objFac.getObject(OBSTACLE, filePath + "/truck1" + "Right.png", 300, 649, 1, 120, 120));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck1"+"Right.png", 600, 649, 1, 120, 120));

        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 100, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 250, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 400, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 550, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 500, 490, -5, 50, 50));
    }

    /**
     * Sets the contents of the new level by calling the functions
     * for setting Obstacles logs turtles etc as well as the music and
     * score
     */
    public void newlevel(){
        instantiateBackground();
        setLogs();
        setTurtle();
        setWetTurtle();
        setEnds();
        setFrog();
        setObstacle();
        setScore();

        getBackground().start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }
}
