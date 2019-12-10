package com.mainPack;


import com.mainPack.gameStart.StartMenu;
import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
class StartMenuTest {

    private String filePath = "file:src/main/resources";
    private static StartMenu test2;
    private Stage primaryStage;
    private static StartMenu screen;

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    //    @Test
//    private void Testing(Stage stage) {
//        this.primaryStage = stage;
//        test2 = StartMenu.getInstance(stage);
//        //test2 = StartMenu.getInstance(primaryStage);
//
//    }
//    @Start
//    private void start(Stage stage) {
//        test2 = StartMenu.getInstance(primaryStage);
//
//    }
//
//    @Test
//    public void TestExitButton() throws AWTException {
//        ClickRobot rob = new ClickRobot() {
//            @Override
//            public void clickOn(MouseButton... mouseButtons) {
//
//            }
//
//            @Override
//            public void clickOn(PointQuery pointQuery, MouseButton... buttons) {
//
//            }
//
//            @Override
//            public void clickOn(PointQuery pointQuery, Motion motion, MouseButton... mouseButtons) {
//
//            }
//
//            @Override
//            public void doubleClickOn(MouseButton... mouseButtons) {
//
//            }
//
//            @Override
//            public void doubleClickOn(PointQuery pointQuery, Motion motion, MouseButton... mouseButtons) {
//
//            }
//        };
//
//        rob.clickOn((PointQuery) test2.exitBtn);
//        Assertions.assertThat(test2).isEqualTo(null);
//    }

}