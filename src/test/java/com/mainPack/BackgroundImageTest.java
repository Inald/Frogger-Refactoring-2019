package com.mainPack;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundImageTest {

    private String filePath = "file:src/main/resources";
    private static BackgroundImage instance;

    @Test
    public void TestInstanceSet(){
        BackgroundImage test2 = null;
        test2 = BackgroundImage.getInstance(filePath + "/iKogsKw2");
        Assertions.assertThat(test2).isNotEqualTo(null);
    }

    @Test
    public void TestDisplayBackgroundImage(){
        Image state = null;
        BackgroundImage test = BackgroundImage.getInstance(filePath + "/iKogsKw2");
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

}