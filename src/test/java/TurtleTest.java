import com.mainPack.froggerGameObjects.Turtle;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

class TurtleTest {

    String filePath = "file:src/main/resources/";

    @Test
    public void TestImageSet(){
        Image state;
        Turtle test = new Turtle(0, 649, 1, 120, 120);
        test.wetTurtle2(120,120);
        state = test.getImage();
        Assertions.assertThat(state).isNotEqualTo(null);
    }

    @Test
    public void testSpeed(){
        int speed = 0;
        Turtle test = new Turtle(0,649,1,120,120);
        speed = test.getSpeed();
        Assertions.assertThat(speed).isEqualTo(1);
    }

}