package com.mainPack;


import javafx.stage.Stage;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


import org.testfx.assertions.api.Assertions;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class HighScoreRWTest {
    private String fileName = "testFile.txt";

    private HighScoreRW RW;
    Stage primaryStage;

    @Start
    private void start(Stage stage) {
        RW = HighScoreRW.getInstance(primaryStage,10,fileName);
    }
    //read write to file
    @Test
    public void testWriteToFile(){
        RW.fileWriting(fileName);
        RW.fileReading(fileName);
        int lastVal = RW.last;
        Assertions.assertThat(lastVal).isEqualTo(10);
    }

    //read file test
    @Test
    public void testReadTestFileAfterUpdate(){
        HighScoreRW RW2 = HighScoreRW.getInstance(primaryStage, 30, fileName);
        RW.fileWriting(fileName);
        RW2.fileWriting(fileName);
        int lastVal = RW2.last;
        Assertions.assertThat(lastVal).isEqualTo(30);
    }

    //bubbleSort test
    @Test
    public void testBubbleSort(){
        boolean state = false;
        int testVal;
        ArrayList<Integer> newArray = new ArrayList<>();
        RW.fileReading(fileName);
        RW.bubbleSort();
        testVal = RW.highScorePrintRW.get(RW.highScorePrintRW.size() - 1);
        for (int i = RW.highScorePrintRW.size() - 1; i > 0; i--){
            if(testVal < RW.highScorePrintRW.get(i)){
                state = false;
            }else{
                state = true;
            }
            testVal = RW.highScorePrintRW.get(i);
        }
        Assertions.assertThat(state).isEqualTo(true);
    }


}