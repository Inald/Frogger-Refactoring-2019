package com.mainPack.froggerGameObstacles;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class WetTurtleTest {
    private String filePath = "file:src/main/resources/";
    private int nineHundredMillion = 900000000;

    @Test
    public void TestImageSet(){
        Image state;
        WetTurtle test = new WetTurtle(0, 649, 1, 120, 120);
        test.setTurtle1(120,120);
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

//    @Test
//    public void isSunk(){
//        WetTurtle test = new WetTurtle(0, 649, 1, 120, 120);
//        long int now = 1382946286033300;
//        if (now/nineHundredMillion  % 4 ==0) {
//            setImage(turtle2);
//            sunk = false;
//
//        }
//    }

}