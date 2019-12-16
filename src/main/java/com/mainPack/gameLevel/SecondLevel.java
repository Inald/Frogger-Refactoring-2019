package com.mainPack.gameLevel;

import javafx.stage.Stage;

/**
 * Second level in the game out of the two, overrides certain methods
 * in the abstact super class in order to work differently
 */
public class SecondLevel extends Levels implements LevelStructure {

    private Stage primaryStage;
    private static final String LOG = "LOG";
    private static final String OBSTACLE = "OBSTACLE";
    private static final String WETTURTLE = "WETTURTLE";

    /**
     * Constructor gets primaryStage from Levels abstract class
     * sets the file to write too, to the level the user plays and calls
     * the newLevel() function to play the game
     * @param primaryStage
     */
    public SecondLevel(Stage primaryStage) {
        super(primaryStage);
        highScoreFile = filePath2 + "highScores2.txt";
        this.primaryStage = primaryStage;
        newlevel();
    }

    /**
     * Class overridden as implementation is different from its parent class
     * as less logs are implemented along with their speeds varying
     */
    @Override
    public void setLogs(){
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(objFac.getObject(LOG,filePath + "/logs.png", 300, 0, 276, -5));


        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 490, 329, 0.75));
    }

    /**
     * Class overridden as implementation is different from its parent
     * class as more, less or different kinds of objects are implemented
     * for example Bird
     */
    @Override
    public void setObstacle(){
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck1"+"Right.png", 0, 649, 2, 120, 120));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck1"+"Right.png", 300, 649, 2, 120, 120));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck1"+"Right.png", 600, 649, 2, 120, 120));

        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 100, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 250, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 400, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 550, 597, -1, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/car1Left.png", 500, 490, -10, 50, 50));
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/bird1.com.png", 250, 420, -5, 50, 50));

    }

    /**
     * Class overridden as implementation is different from its parent
     * class as more wetTurtles are implemented
     */
    @Override
    public void setWetTurtle(){
        getBackground().add(objFac.getObject(WETTURTLE, "", 500, 376, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE,"",300, 376, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE, "", 700, 376, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE, "",600, 217, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE, "",400, 217, -1, 130, 130));
        getBackground().add(objFac.getObject(WETTURTLE, "",200, 217, -1, 130, 130));
    }

    @Override
    public void setTurtle(){

    }

    /**
     * newLevel overridden to cater for changes made in the
     * second level of the game
     */
    @Override
    public void newLevel() {
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
