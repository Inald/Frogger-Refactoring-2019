package com.mainPack;

import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HighScoreRW {


    public static HighScoreRW instance;
    Stage primaryStage;
    private int points;
    String filePathRW;
    ArrayList<Integer> highScorePrintRW = new ArrayList<>();

    public static HighScoreRW getInstance(Stage primaryStage, int gamePoints, String filePathRW){
        if(instance == null){
            return new HighScoreRW(primaryStage, gamePoints, filePathRW);
        }
        return instance;
    }

    private HighScoreRW(Stage primaryStage, int gamePoints, String filePathRW) {
        this.points = gamePoints;
        this.primaryStage = primaryStage;
        this.fileWriting(filePathRW);
        this.fileReading(filePathRW);


    }

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

    public ArrayList<Integer> highScores(){
        highScorePrintRW = bubbleSort();
        return highScorePrintRW;
    }


    public void fileReading(String filePathRW){
        this.filePathRW = filePathRW;
        try{
            BufferedReader read = new BufferedReader(new FileReader(this.filePathRW));
            String highScoreLine;
            int i = 0;
            while((highScoreLine = read.readLine()) != null){
                highScorePrintRW.add(Integer.valueOf(highScoreLine));
                //System.out.println(highScorePrint.get(i));
                i++;
            }
            read.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //highScorePrintRW = bubbleSort();
    }
}
