package com.mainPack.froggerGameObjects;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;

class LogTest {

    private String filePath = "file:src/main/resources";
    private int speed;
    //Log logObj;
    @Start
    private void start(Stage stage) {
//        logObj = new Log(filePath + "/log3.png", 150, 0, 166, 1);
    }

    @Test
    public void testGetLeftTrue(){
        Log logObj = new Log(filePath + "/log3.png", 150, 0, 166, 1);
        boolean state = true;
        state = logObj.getLeft();
        Assertions.assertThat(state).isEqualTo(false);
    }

    @Test
    public void testGetLeftFalse(){
        boolean state = false;
        Log logObj2 = new Log(filePath + "/log3.png", 150 , 0, 166, -2);
        state = logObj2.getLeft();
        Assertions.assertThat(state).isEqualTo(true);
    }

    @Test
    public void TestImageSet(){
        Image state;
        Log test = new Log(filePath + "/log3.png", 0, 649, 1, -2);
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

    @Test
    public void testSpeed(){
        double speed = 0;
        Log test = new Log(filePath + "/log3.png", 0, 649, 4,10);
        speed = test.getSpeed();
        Assertions.assertThat(speed).isEqualTo(10);
    }


}