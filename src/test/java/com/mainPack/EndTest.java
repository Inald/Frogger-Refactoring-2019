package com.mainPack;

import com.mainPack.background.End;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

class EndTest {

    private String filePath = "file:src/main/resources";

    @Test
    public void TestSetEnd(){
        Image state;
        End test = new End(5,5);
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

    @Test
    public void TestEndActivated(){
        boolean isEndOccupied;
        Image state;
        End test = new End(5,5);
        test.setEnd();
        isEndOccupied = test.isActivated();
        Assertions.assertThat(isEndOccupied).isEqualTo(true);
    }


}