package gameLevel;

import com.mainPack.Main;
import javafx.stage.Stage;

public class gameFactory extends Main {

    private Stage primaryStage;

    public gameFactory(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Levels newGame(String gameVal){
        if(gameVal.equals("1")){
           return new firstLevel(primaryStage);
        }else if(gameVal.equals("2")){
            //implement level 2
        }

        return null;
    }

}