package gameLevel;

import javafx.stage.Stage;

public class FirstLevel extends Levels implements LevelStructure {

    private Stage primaryStage;
    //private String highScoreFile;

    /**
     * Constructor for firstLevel takes the superclass' primaryStage
     * sets the new file to write to, and calls newLevel from the parent
     * class Levels
     * @param primaryStage
     */
    public FirstLevel(Stage primaryStage) {
        super(primaryStage);
        highScoreFile = filePath2 + "highScores.txt";
        newlevel();
    }

    @Override
    public void newLevel() {

    }


}
