package gameLevel;

import com.mainPack.Main;
import javafx.stage.Stage;

public class GameFactory extends Main {

    private Stage primaryStage;

    public GameFactory(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

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