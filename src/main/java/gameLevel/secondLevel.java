package gameLevel;

import com.mainPack.froggerGameObstacles.Log;
import com.mainPack.froggerGameObstacles.Obstacle;
import javafx.stage.Stage;

public class secondLevel extends Levels implements levelStructure {

    private Stage primaryStage;

    public secondLevel(Stage primaryStage) {
        super(primaryStage);
        this.primaryStage = primaryStage;
        newlevel();
    }

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

    @Override
    public void setLogs(){
        getBackground().add(new Log(filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(new Log(filePath + "/logs.png", 300, 0, 276, -2));


        getBackground().add(new Log(filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 490, 329, 0.75));
    }

    @Override
    public void setObstacle(){
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 0, 649, 2, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 300, 649, 2, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 600, 649, 2, 120, 120));

        getBackground().add(new Obstacle(filePath + "/car1Left.png", 100, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 400, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 550, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 500, 490, -10, 50, 50));
        getBackground().add(new Obstacle(filePath + "/bird1.com.png", 250, 270, -5, 50, 50));
    }
}
