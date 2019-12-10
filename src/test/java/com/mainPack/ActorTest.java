package com.mainPack;

import com.mainPack.froggerGameObjects.Actor;
import com.mainPack.froggerGameObjects.Obstacle;
import gameLevel.BlankLevel;
import gameLevel.Levels;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class ActorTest {

    String filePath = "file:resources";
    private BlankLevel level;
    Levels actInst;

    @Start
    private void start(Stage stage) {
        level = new BlankLevel(stage);
        //actInst = level.getBackground().add(new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50));
    }

    @Test
    public void moveTest(){
        int x = 2;
        int y = 2;
        Actor newObj = new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50);


    }
}