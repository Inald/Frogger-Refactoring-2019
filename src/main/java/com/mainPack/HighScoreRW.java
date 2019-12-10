package com.mainPack;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Purpose of class is to read and write the highscores at the
 * end of either level that the user chooses to play
 */
public class HighScoreRW {


    public static HighScoreRW instance;
    Stage primaryStage;
    private int points;
    /**
     * used to check the last value entered in testing
     */
    public int last;
    String filePathRW;
    /**
     * Stores the highscores in this array
     */
    ArrayList<Integer> highScorePrintRW = new ArrayList<>();

    /**
     * Returns the instance if the object has already been created, otherwise
     * creates a new HighScoreRW object
     * @param primaryStage
     * @param gamePoints
     * @param filePathRW
     * @return
     */
    public static HighScoreRW getInstance(Stage primaryStage, int gamePoints, String filePathRW){
        if(instance == null){
            return new HighScoreRW(primaryStage, gamePoints, filePathRW);
        }
        return instance;
    }

    /**
     * constructor for the HighScoreRW class schedules the reading of the file
     * once writing to the file has taken place
     * @param primaryStage
     * @param gamePoints
     * @param filePathRW
     */
    private HighScoreRW(Stage primaryStage, int gamePoints, String filePathRW) {
        this.points = gamePoints;
        this.primaryStage = primaryStage;
        this.fileWriting(filePathRW);
        this.fileReading(filePathRW);


    }

    /**
     * Writes the score to the selected file saved in resources
     * @param filePathRW
     */
    public void fileWriting(String filePathRW){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathRW, true));
            writer.newLine();
            writer.append(String.valueOf(points));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sorts the array list in a bubbleSort fashion and stores the values
     * back in the arrayList
     * @return
     */
    public ArrayList<Integer> bubbleSort(){
        int temp;
        int j1;
        int jplus1;

        for(int k = highScorePrintRW.size(); k > 0; k--){
            for(int j = 0; j < k - 1; j++){
                j1 = (highScorePrintRW.get(j));
                jplus1 = (highScorePrintRW.get(j));

                if(highScorePrintRW.get(j).compareTo(highScorePrintRW.get(j + 1)) > 0){
                    temp = (highScorePrintRW.get(j));
                    highScorePrintRW.set(j, highScorePrintRW.get(j +1));
                    highScorePrintRW.set(j+1, temp);
                }
            }
        }
        return highScorePrintRW;
    }

    /**
     * Returns the sorted array list
     * @return
     */
    public ArrayList<Integer> highScores(){
        highScorePrintRW = bubbleSort();
        return highScorePrintRW;
    }

    /**
     * Reads the file path of the parameter and writes to the arrayList
     * so the highscores can be printed at the end of the game
     * @param filePathRW
     */
    public void fileReading(String filePathRW){
        this.filePathRW = filePathRW;
        try{
            BufferedReader read = new BufferedReader(new FileReader(this.filePathRW));
            String highScoreLine;
            int i = 0;
            while((highScoreLine = read.readLine()) != null){
                highScorePrintRW.add(Integer.valueOf(highScoreLine));
                //Last used for testing purposes
                last = (Integer.parseInt(highScoreLine));
                i++;
            }
            read.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //highScorePrintRW = bubbleSort();
    }


}
