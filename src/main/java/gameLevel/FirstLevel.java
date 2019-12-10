package gameLevel;

import javafx.stage.Stage;

/**
 * One of the two levels in the game calls newLevel as implementation
 * for this level is in the abstract class Levels which it extends
 */
public class FirstLevel extends Levels implements LevelStructure {

    private Stage primaryStage;
    //private String highScoreFile;

    /**
     * Constructor for firstLevel takes the super class' primaryStage
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
