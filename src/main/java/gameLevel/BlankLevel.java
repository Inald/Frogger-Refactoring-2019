package gameLevel;

import javafx.stage.Stage;

public class BlankLevel extends Levels implements LevelStructure {
    private Stage primaryStage;

    /**
     * Constructor for blankLevel takes the superclass'
     * PrimaryStage and calls the testingLevel() function
     * @param primaryStage
     */
    public BlankLevel(Stage primaryStage) {
        super(primaryStage);
        this.primaryStage = primaryStage;
        testingLevel();
    }

    /**
     * Sets up the requirements needed for the testing
     * level e.g. obstacles not needed
     */
    public void testingLevel(){
        instantiateBackground(); //needed or tests break
        setFrog();
        setEnds();
        getBackground().start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }


    @Override
    public void newLevel() {

    }
}
