package gameLevel;

import com.mainPack.HighScoreRW;
import com.mainPack.froggerGameObstacles.Log;
import com.mainPack.froggerGameObstacles.Obstacle;
import com.mainPack.StartMenu;
import com.mainPack.froggerGameObstacles.Turtle;
import com.mainPack.froggerGameObstacles.WetTurtle;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class SecondLevel extends Levels implements LevelStructure {

    private Stage primaryStage;
    ArrayList<Integer> highScorePrint = new ArrayList<>();
    private static final String LOG = "LOG";
    private static final String OBSTACLE = "OBSTACLE";
    private static final String WETTURTLE = "WETTURTLE";


    public SecondLevel(Stage primaryStage) {
        super(primaryStage);
        highScoreFile = filePath2 + "highScores2.txt";
        this.primaryStage = primaryStage;
        newlevel();
    }


    @Override
    public void setLogs(){
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(objFac.getObject(LOG,filePath + "/logs.png", 300, 0, 276, -5));


        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(objFac.getObject(LOG,filePath + "/log3.png", 150, 490, 329, 0.75));
    }

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
        getBackground().add(objFac.getObject(OBSTACLE,filePath + "/bird1.com.png", 250, 440, -5, 50, 50));

    }

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
    public void newLevel() {
        instantiateBackground();
        setLogs();
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
