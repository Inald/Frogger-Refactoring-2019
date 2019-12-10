package com.mainPack.froggerGameObjects;

import org.testfx.assertions.api.Assertions;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

class ObstacleTest {

    String filePath = "file:src/main/resources/";

    @Test
    public void TestImageSet(){
        Image state;
        Obstacle test = new Obstacle(filePath + "truck1"+"Right.png", 0, 649, 1, 120, 120);
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

}