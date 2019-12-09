package gameLevel;

import com.mainPack.Main;
import javafx.stage.Stage;

public class GameFactory extends Main {

    private Stage primaryStage;

    /**
     * Constructor sets the global primary Stage to
     * the Stage value passed in
     * @param primaryStage
     */
    public GameFactory(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * newGame takes a parameter based on the level the user
     * chooses and creates a new object depending on the level
     * and returns it
     * @param gameVal
     * @return
     */
    public Levels newGame(String gameVal){
        if(gameVal.equals("1")){
            //implementation of level 1
            return new FirstLevel(primaryStage);
        }else if(gameVal.equals("2")){
            //implementation of level 2
            return new SecondLevel(primaryStage);
        }

        return null;
    }

}
