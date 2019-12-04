package gameLevel;

import com.mainPack.froggerGameObstacles.Log;
import com.mainPack.froggerGameObstacles.Obstacle;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class secondLevel extends Levels implements levelStructure {

    private Stage primaryStage;

    public secondLevel(Stage primaryStage) {
        super(primaryStage);
        this.primaryStage = primaryStage;
        newlevel();
    }

    public void newlevel(){
        instantiateBackground();
        setLogs();
        setTurtle();
        setWetTurtle();
        setEnds();
        setFrog();
        setObstacle();
        setScore();
        getBackground().start();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }

    @Override
    public void setLogs(){
        getBackground().add(new Log(filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(new Log(filePath + "/logs.png", 300, 0, 276, -2));


        getBackground().add(new Log(filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 490, 329, 0.75));
    }

    @Override
    public void setObstacle(){
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 0, 649, 2, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 300, 649, 2, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 600, 649, 2, 120, 120));

        getBackground().add(new Obstacle(filePath + "/car1Left.png", 100, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 400, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 550, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 500, 490, -10, 50, 50));
        //getBackground().add(new Obstacle(filePath + "/bird1.com.png", 250, 270, -5, 50, 50));
    }

    @Override
    public void createTimer() {
        String highScoreFile = filePath + "/highScores.txt";
        ArrayList<Integer> highScorePrint = new ArrayList<>();
        setTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (getAnimal().changeScore()) {
                    setNumber(getAnimal().getPoints());
                }
                if (getAnimal().getStop()) {
                    System.out.print("STOPP:");
                    getBackground().stopMusic();
                    stop();
                    getBackground().stop();

                    //Writing to file
                    try{
                        BufferedWriter writer = new BufferedWriter(new FileWriter("highScores2.txt", true));
                        writer.newLine();
                        writer.append(String.valueOf(getAnimal().getPoints()));
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //Reading from file
                    try{
                        BufferedReader read = new BufferedReader(new FileReader("highScores2.txt"));
                        String highScoreLine;
                        int i = 0;
                        while((highScoreLine = read.readLine()) != null){
                            highScorePrint.add(Integer.valueOf(highScoreLine));
                            //System.out.println(highScorePrint.get(i));
                            i++;
                        }
                        read.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    //bubble sort to print highest scores first
                    int temp;
                    int j1;
                    int jplus1;

                    for(int k = highScorePrint.size(); k > 0; k--){
                        for(int j = 0; j < k - 1; j++){
                            j1 = (highScorePrint.get(j));
                            jplus1 = (highScorePrint.get(j));

                            if(highScorePrint.get(j).compareTo(highScorePrint.get(j + 1)) > 0){
                                temp = (highScorePrint.get(j));
                                highScorePrint.set(j, highScorePrint.get(j +1));
                                highScorePrint.set(j+1, temp);
                            }
                        }
                    }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    DialogPane customPane = alert.getDialogPane();
                    customPane.getStylesheets().add("startScreenCustom.css");
                    customPane.getStyleClass().add("dialogWriting");
                    customPane.getStyleClass().add("Dialog");
                    customPane.getStyleClass().add("dialogHeader");
                    customPane.getStyleClass().add("dialogTopLabel");
                    alert.setHeight(600);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ getAnimal().getPoints()+"!");

                    StringBuffer stringBuf = new StringBuffer();

                    for(int j = highScorePrint.size() - 1; j > 0; j--){
                        stringBuf.append(String.valueOf(highScorePrint.get(j)) + "\n");
                    }

                    alert.setContentText("Highest Possible Score Achieved: " + highScorePrint.get(highScorePrint.size() - 1)+ "\n" +
                            "High scores achieved by players:\n" +
                            stringBuf);


                    alert.show();
                }
            }
        });
    }
}
