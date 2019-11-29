package com.mainPack;

import javafx.stage.Stage;

public class BlankLevel extends Levels{
    private Stage primaryStage;

    public BlankLevel(Stage primaryStage) {
        this.primaryStage = primaryStage;
        testingLevel();
    }

    public void testingLevel(){
        instantiateBackground();
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
