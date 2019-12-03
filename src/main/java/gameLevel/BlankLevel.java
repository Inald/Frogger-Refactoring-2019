package gameLevel;

import com.mainPack.froggerGameObstacles.Animal;
import javafx.stage.Stage;

public class BlankLevel extends Levels {
    private Stage primaryStage;

    public BlankLevel(Stage primaryStage) {
        super(primaryStage);
        this.primaryStage = primaryStage;
        testingLevel();
    }

    public void testingLevel(){
        instantiateBackground(); //needed or tests break
        setFrog();
        getBackground().start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }

    public void setFrog(){
        setAnimal(new Animal(filePath + "/froggerUp.png"));
        getBackground().add(getAnimal());
    }
}
