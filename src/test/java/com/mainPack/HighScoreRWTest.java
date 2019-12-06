package com.mainPack;


import javafx.stage.Stage;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


import org.testfx.assertions.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class HighScoreRWTest {
    String fileName = "testFile.txt";

    HighScoreRW RW;
    Stage primaryStage;
    @Start
    private void start(Stage stage) {
        RW = HighScoreRW.getInstance(primaryStage,10,fileName);
    }

    @Test
    public void testWriteToFile(){
        RW.fileWriting(fileName);
        RW.fileReading(fileName);
        int lastVal = RW.last;
        Assertions.assertThat(lastVal).isEqualTo(10);
    }

    @Test
    public void testUpdateTestFile(){
        HighScoreRW RW2 = HighScoreRW.getInstance(primaryStage, 30, fileName);
        RW.fileWriting(fileName);
        RW2.fileWriting(fileName);
        int lastVal = RW2.last;
        Assertions.assertThat(lastVal).isEqualTo(30);

    }

}