package com.mainPack;


import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class StartMenuTest {

    private String filePath = "file:src/main/resources";
    private static StartMenu test2 = null;
    private Stage primaryStage;
    private static StartMenu screen;
   // Animal aniInst;

//    @Start
//    private void start(Stage stage) {
//        this.primaryStage = stage;
//        //test2 = StartMenu.getInstance(primaryStage);
//        //aniInst = level.getAnimal();
//    }
//
//    @Test
//    public void TestInstanceSet(Stage stage){
//        test2 = StartMenu.getInstance(primaryStage);
//        Assertions.assertThat(test2).isNotEqualTo(null);
//    }

}