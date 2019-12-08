package com.mainPack;

import com.mainPack.froggerGameObstacles.Log;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class EndTest {

    private String filePath = "file:src/main/resources";

    @Test
    public void TestSetEnd(){
        Image state;
        End test = new End(5,5);
        test.setEnd();
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }


}