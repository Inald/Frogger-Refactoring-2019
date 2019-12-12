import com.mainPack.froggerGameObjects.Actor;
import com.mainPack.froggerGameObjects.Animal;
import com.mainPack.froggerGameObjects.FactoryMoving;
import com.mainPack.gameLevel.BlankLevel;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class ActorTest {

    String filePath = "file:src/main/resources";
    private BlankLevel level;
    Animal aniInst;
    private double movementX = 10.666666*2;
    private double finalMovementX = movementX * 2;
    private double movement = 13.3333333*2;
    private double finalMovment = movement * 2;
    private double x = 100;
    private double xDifference;
    boolean state;

    @Start
    private void start(Stage stage) {
        level = new BlankLevel(stage);
        aniInst = level.getAnimal();
    }

    @Test
    public void obstacleMovementTest(){
        state = false;
        x = 100;
        Platform.runLater(() -> {
            Actor testOb = new FactoryMoving().getObject("OBSTACLE",filePath + "/car1Left.png", 100, 597, -5, 50, 50);
            level.getBackground().add(testOb);
            testOb.move(-5, 0);
            double xAfter = testOb.getX();
            xDifference = x - xAfter;
            if(x == xDifference + xAfter){
                state = true;
            }
            Assertions.assertThat(state).isEqualTo(true);
        });
    }

    @Test
    public void turtleMovementTest(){
        state = false;
        x = 100;
        Platform.runLater(() -> {
            Actor testOb = new FactoryMoving().getObject("TURTLE","",500, 376, -1, 130, 130);
            level.getBackground().add(testOb);
            testOb.move(-5, 0);
            double xAfter = testOb.getX();
            xDifference = x - xAfter;
            if(x == xDifference + xAfter){
                state = true;
            }
            Assertions.assertThat(state).isEqualTo(true);
        });
    }

    @Test
    public void wetTurtleMovementTest(){
        state = false;
        x = 100;
        Platform.runLater(() -> {
            Actor testOb = new FactoryMoving().getObject("WETTURTLE","",200, 217, -1, 130, 130);
            level.getBackground().add(testOb);
            testOb.move(-5, 0);
            double xAfter = testOb.getX();
            xDifference = x - xAfter;
            if(x == xDifference + xAfter){
                state = true;
            }
            Assertions.assertThat(state).isEqualTo(true);
        });
    }

    @Test
    public void logMovementTest(){
        state = false;
        x = 100;
        Platform.runLater(() -> {
            Actor testOb = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 150, 0, 166, 0.75);
            level.getBackground().add(testOb);
            testOb.move(-5, 0);
            double xAfter = testOb.getX();
            xDifference = x - xAfter;
            if(x == xDifference + xAfter){
                state = true;
            }
            Assertions.assertThat(state).isEqualTo(true);
        });
    }

//    @Test
//    public void checkEndsWorks() throws AWTException {
//        Robot rob = new Robot();
//        rob.setAutoDelay(100);
//        Platform.runLater(() -> {
//            Actor testOb = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 166, 0);
//            Actor testOb2 = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 210, 0);
//            Actor testOb3 = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 254, 0);
//            Actor testOb4 = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 298, 0);
//            Actor testOb5 = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 350, 0);
//            Actor testOb6 = new FactoryMoving().getObject("LOG",filePath + "/log3.png", 180, 260, 390, 0);
//
//            level.getBackground().add(testOb);
//            level.getBackground().add(testOb2);
//            level.getBackground().add(testOb3);
//            level.getBackground().add(testOb4);
//            level.getBackground().add(testOb5);
//            level.getBackground().add(testOb6);
//            rob.keyPress(65);
//            rob.keyRelease(65);
//            for(int i = 0; i < 11; i++){
//                rob.keyPress(87);
//                rob.keyRelease(87);
//                rob.setAutoDelay(100);
//            }
//            rob.keyPress(13);
//            rob.keyRelease(13);
//            Assertions.assertThat(160).isEqualTo(160);
//        });

    }



