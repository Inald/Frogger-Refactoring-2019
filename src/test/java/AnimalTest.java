

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
    public void getPointsTest(){
        Assertions.assertThat(aniInst.getPoints()).isEqualTo(0);
    }

}