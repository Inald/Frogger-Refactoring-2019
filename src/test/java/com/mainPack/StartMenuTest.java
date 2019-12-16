package com.mainPack;


import com.mainPack.gameStart.StartMenu;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class StartMenuTest {

    private String filePath = "file:src/main/resources";
    public static StartMenu test2;
    private Stage primaryStage;
    private static StartMenu screen;
    private static StartMenu test3;
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    @Start
    private void start(Stage stage) {
        test2 = StartMenu.getInstance(primaryStage);
    }

//    @Test
//    public void getInstanceTest(){
//        test2.exitBtn.isPressed();
//        Assertions.assertThat(test2).isNotEqualTo(null);
//    }

}