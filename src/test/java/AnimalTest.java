

import com.mainPack.Animal;
import com.mainPack.BlankLevel;
import com.mainPack.firstLevel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;

@ExtendWith(ApplicationExtension.class)
class AnimalTest {

    String filePath = "file:resources";
    private BlankLevel level;
    Animal aniInst;
    private double movementX = 10.666666*2;
    private double movement = 13.3333333*2;

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
        boolean working = (x == afterX + (movementX * 2));
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
        boolean working = (x == afterX - (movementX * 2));
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
        boolean working = (y == afterY + (movement * 2));
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


}