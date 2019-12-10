

import com.mainPack.froggerGameObjects.Animal;
import gameLevel.BlankLevel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

@ExtendWith(ApplicationExtension.class)
class AnimalTest {

    String filePath = "file:resources";
    private BlankLevel level;
    Animal aniInst;
    private double movementX = 10.666666*2;
    private double finalMovementX = movementX * 2;
    private double movement = 13.3333333*2;
    private double finalMovment = movement * 2;

    @Start
    private void start(Stage stage) {
        level = new BlankLevel(stage);
        aniInst = level.getAnimal();
    }
    //start menu branch test
    @Test
    public void PointsIsZero(){
        Animal newAni = new Animal(filePath + "/froggerUp.png");
        Assertions.assertThat(newAni.getPoints()).isEqualTo(0);
    }

    @Test
    public void PointsIncrement(){
        int add = 20;
        Animal newAni = new Animal(filePath + "/froggerUp.png");
        newAni.addPoints(add);
        Assertions.assertThat(newAni.getPoints()).isEqualTo(20);
    }

    @Test
    public void PointsDecrement(){
        int minus = 20;
        Animal newAni = new Animal(filePath + "/froggerUp.png");
        newAni.setPoints(50);
        newAni.minusPoints(minus);
        Assertions.assertThat(newAni.getPoints()).isEqualTo(30);
    }

    @Test
    public void negativePoints(){
        int negative = 20;
        Animal newAni = new Animal(filePath + "/froggerUp.png");
        newAni.setPoints(0);
        newAni.minusPoints(negative);
        Assertions.assertThat(newAni.getPoints()).isEqualTo(0);
    }

    @Test
    //test for button A working properly
    public void keyPressedA() throws AWTException {
        double x = aniInst.getX();
        double y = aniInst.getY();
        Robot Rob = new Robot();
        Rob.setAutoDelay(100);
        Rob.keyPress(65);
        Rob.keyRelease(65);
        double afterX = aniInst.getX();
        double afterY = aniInst.getY();
        boolean working = (x == afterX + (finalMovementX));
        Assertions.assertThat(working).isEqualTo(true);
    }

    @Test
    public void keyPressedD() throws AWTException {
        double x = aniInst.getX();
        double y = aniInst.getY();
        Robot Rob = new Robot();
        Rob.setAutoDelay(100);
        Rob.keyPress(68);
        Rob.keyRelease(68);
        double afterX = aniInst.getX();
        double afterY = aniInst.getY();
        boolean working = (x == afterX - (finalMovementX));
        Assertions.assertThat(working).isEqualTo(true);
    }
    
    @Test
    public void keyPressedW() throws AWTException {
        double x = aniInst.getX();
        double y = aniInst.getY();
        Robot Rob = new Robot();
        Rob.setAutoDelay(100);
        Rob.keyPress(87);
        Rob.keyRelease(87);
        double afterX = aniInst.getX();
        double afterY = aniInst.getY();
        boolean working = (y == afterY + (finalMovment));
        Assertions.assertThat(working).isEqualTo(true);
    }

    @Test
    public void keyPressedS() throws AWTException {
        double x = aniInst.getX();
        double y = aniInst.getY();
        Robot Rob = new Robot();
        Rob.setAutoDelay(100);
        Rob.keyPress(87);
        Rob.keyPress(87);
        Rob.keyPress(83);
        Rob.keyRelease(83);
        double afterX = aniInst.getX();
        double afterY = aniInst.getY();
        boolean working = (y == afterY);
        Assertions.assertThat(working).isEqualTo(true);
    }

    @Test
    public void testBoundaryDown() throws AWTException {
        double y = aniInst.getY();
        Robot rob = null;
        rob = new Robot();
        rob.setAutoDelay(100);
        rob.keyPress(83);//83 for S key
        rob.keyRelease(83);
        double afterY = aniInst.getY();
        boolean inBounds = (y == afterY);
        Assertions.assertThat(inBounds).isEqualTo(true);
    }

    @Test
    public void testBoundaryLeft(){
        Robot rob = null;
        try {
            rob = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++){
            rob.keyPress(65);//65 for A to go left
            rob.keyRelease(65);
        }
        double x = aniInst.getX();
        rob.keyPress(65);
        rob.keyRelease(65);
        double xAfter = aniInst.getX();
        boolean inBounds = (x == xAfter);
        Assertions.assertThat(inBounds).isEqualTo(true);
    }

//    @Test
//    public void testBoundaryRight(){
//        Robot rob = null;
//        try {
//            rob = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 7; i++){
//            rob.keyPress(68);//65 for A to go left
//            rob.keyRelease(68);
//        }
//        double x = aniInst.getX();
//        rob.keyPress(68);
//        rob.keyRelease(68);
//        double xAfter = aniInst.getX();
//        boolean inBounds = (x == xAfter);
//        Assertions.assertThat(inBounds).isEqualTo(true);
//    }

    @Test
    public void waterDeathTest() throws AWTException {
        boolean waterDeath = aniInst.isWaterDeath();
        Robot Rob = new Robot();
        Rob.setAutoDelay(100);
        for(int i = 0; i < 6; i++) {
            Rob.keyPress(87);
            Rob.keyRelease(87);
        }
        waterDeath = aniInst.isWaterDeath();
        Assertions.assertThat(waterDeath).isEqualTo(true);
    }

//    @Test
//    public void obstacleTest(){
//
//        Platform.runLater(() -> {
//            Obstacle testOb = new Obstacle(filePath + "/car1Left.png", 100, 597, -5, 50, 50);
//            level.getBackground().add(testOb);
//        });
//    }




}