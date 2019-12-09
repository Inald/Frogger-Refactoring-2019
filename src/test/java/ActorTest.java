import com.mainPack.Actor;
import com.mainPack.froggerGameObstacles.Animal;
import com.mainPack.froggerGameObstacles.FactoryMoving;
import com.mainPack.froggerGameObstacles.Moving;
import gameLevel.BlankLevel;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.atomic.AtomicBoolean;

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
            ((Moving) testOb).move(-5, 0);
            double xAfter = testOb.getX();
            xDifference = x - xAfter;
            System.out.println(xDifference);
            System.out.println(x);
            System.out.println(xAfter);
            if(x == xDifference + xAfter){
                state = true;
            }
            Assertions.assertThat(state).isEqualTo(true);
        });
    }

}