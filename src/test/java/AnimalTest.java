

import com.mainPack.Animal;
import com.mainPack.firstLevel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class AnimalTest {

    String filePath = "file:resources";
    private firstLevel level;
    Animal aniInst;


    @Start
    private void start(Stage stage) {
        level = new firstLevel(stage);
        aniInst = level.getAnimal();
    }

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



}