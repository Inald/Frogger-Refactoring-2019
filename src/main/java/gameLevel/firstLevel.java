package gameLevel;

import com.mainPack.froggerGameObstacles.Animal;
import com.mainPack.End;
import com.mainPack.froggerGameObstacles.Log;
import com.mainPack.froggerGameObstacles.Obstacle;
import com.mainPack.froggerGameObstacles.Turtle;
import com.mainPack.froggerGameObstacles.WetTurtle;
import javafx.stage.Stage;

public class firstLevel extends Levels implements levelStructure {

    private Stage primaryStage;
    private String highScoreFile;


    public firstLevel(Stage primaryStage) {
        super(primaryStage);
        newlevel();
    }

    @Override
    public void newLevel() {

    }


//    public void newlevel(){
//        instantiateBackground();
//        setLogs();
//        setTurtle();
//        setWetTurtle();
//        setEnds();
//        setFrog();
//        setObstacle();
//        setScore();
//        getBackground().start();
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        start();
//    }

//    public void setEnds(){
//        getBackground().add(new End(13,96));
//        getBackground().add(new End(141,96));
//        getBackground().add(new End(141 + 141-13,96));
//        getBackground().add(new End(141 + 141-13+141-13+1,96));
//        getBackground().add(new End(141 + 141-13+141-13+141-13+3,96));
//    }
//
//    public void setFrog(){
//        setAnimal(new Animal(filePath + "/froggerUp.png"));
//        getBackground().add(getAnimal());
//    }
//
//
//    public void setLogs(){
//        getBackground().add(new Log(filePath + "/log3.png", 150, 0, 166, 0.75));
//        getBackground().add(new Log(filePath + "/log3.png", 150, 220, 166, 0.75));
//        getBackground().add(new Log(filePath + "/log3.png", 150, 440, 166, 0.75));
//
//        getBackground().add(new Log(filePath + "/logs.png", 300, 0, 276, -2));
//        getBackground().add(new Log(filePath + "/logs.png", 300, 400, 276, -2));
//
//        getBackground().add(new Log(filePath + "/log3.png", 150, 50, 329, 0.75));
//        getBackground().add(new Log(filePath + "/log3.png", 150, 270, 329, 0.75));
//        getBackground().add(new Log(filePath + "/log3.png", 150, 490, 329, 0.75));
//    }
//
//    public void setTurtle(){
//        getBackground().add(new Turtle(500, 376, -1, 130, 130));
//        getBackground().add(new Turtle(300, 376, -1, 130, 130));
//    }
//
//    public void setWetTurtle(){
//        getBackground().add(new WetTurtle(700, 376, -1, 130, 130));
//        getBackground().add(new WetTurtle(600, 217, -1, 130, 130));
//        getBackground().add(new WetTurtle(400, 217, -1, 130, 130));
//        getBackground().add(new WetTurtle(200, 217, -1, 130, 130));
//    }
//
//    public void setObstacle(){
//        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 0, 649, 1, 120, 120));
//        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 300, 649, 1, 120, 120));
//        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 600, 649, 1, 120, 120));
//
//        getBackground().add(new Obstacle(filePath + "/car1Left.png", 100, 597, -1, 50, 50));
//        getBackground().add(new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50));
//        getBackground().add(new Obstacle(filePath + "/car1Left.png", 400, 597, -1, 50, 50));
//        getBackground().add(new Obstacle(filePath + "/car1Left.png", 550, 597, -1, 50, 50));
//        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
//        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
//        getBackground().add(new Obstacle(filePath + "/car1Left.png", 500, 490, -5, 50, 50));
//    }

}
