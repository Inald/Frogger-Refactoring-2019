package gameLevel;

import com.mainPack.*;
import com.mainPack.froggerGameObstacles.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public abstract class Levels implements LevelStructure {
    private AnimationTimer timer;
    private MyStage background;
    private Animal animal;
    private Stage primaryStage;

    public Levels(Stage primaryStage){
        this.primaryStage = primaryStage;

    }

    protected String filePath = "file:src/main/resources";
    protected Scene scene;
    ArrayList<Integer> highScorePrint = new ArrayList<>();

    public void instantiateBackground(){
        setBackground(new MyStage());
        scene = new Scene(getBackground(), 600, 800);
        BackgroundImage froggerback = BackgroundImage.getInstance(filePath + "/iKogsKw.png");

        getBackground().add(froggerback);
    }

    public void createTimer() {
        String highScoreFile = filePath + "/highScores.txt";
        //ArrayList<Integer> highScorePrint = new ArrayList<>();
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

//                    //Writing to file
//                    try{
//                        BufferedWriter writer = new BufferedWriter(new FileWriter("highScores.txt", true));
//                        writer.newLine();
//                        writer.append(String.valueOf(getAnimal().getPoints()));
//                        writer.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    //Reading from file
//                    try{
//                        BufferedReader read = new BufferedReader(new FileReader("highScores.txt"));
//                        String highScoreLine;
//                        int i = 0;
//                        while((highScoreLine = read.readLine()) != null){
//                            highScorePrint.add(Integer.valueOf(highScoreLine));
//                            //System.out.println(highScorePrint.get(i));
//                            i++;
//                        }
//                        read.close();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//
//                    //bubble sort to print highest scores first
//                    int temp;
//                    int j1;
//                    int jplus1;
//
//                    for(int k = highScorePrint.size(); k > 0; k--){
//                        for(int j = 0; j < k - 1; j++){
//                            j1 = (highScorePrint.get(j));
//                            jplus1 = (highScorePrint.get(j));
//
//                            if(highScorePrint.get(j).compareTo(highScorePrint.get(j + 1)) > 0){
//                                temp = (highScorePrint.get(j));
//                                highScorePrint.set(j, highScorePrint.get(j +1));
//                                highScorePrint.set(j+1, temp);
//                            }
//                        }
//                    }
                    //write to the correct file.
                    HighScoreRW RW = HighScoreRW.getInstance(primaryStage, getAnimal().getPoints(), "highScores.txt");
                    highScorePrint = RW.highScores();

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

                    alert.setContentText("Highest Possible Score: 800\n" +
                            "High scores achieved by players:\n" +
                            stringBuf);


                    alert.show();
                    //HighScoreRW RW = HighScoreRW.getInstance(primaryStage, getAnimal().getPoints());
                    //highScorePrint = RW.highScores();
                    StartMenu backToStart = StartMenu.getInstance(primaryStage);
                    backToStart.displayStart();
                }
            }
        });
    }


    public void start() {
        getBackground().playMusic();
        createTimer();
        getTimer().start();
    }

    public void stop() {
        getTimer().stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            getBackground().add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }

    public void setScore(){
        getBackground().add(new Digit(0, 30, 360, 25));
    }

    public AnimationTimer getTimer() {
        return timer;
    }

    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }

    public MyStage getBackground() {
        return background;
    }

    public void setBackground(MyStage background) {
        this.background = background;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setEnds(){
        getBackground().add(new End(13,96));
        getBackground().add(new End(141,96));
        getBackground().add(new End(141 + 141-13,96));
        getBackground().add(new End(141 + 141-13+141-13+1,96));
        getBackground().add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    public void setFrog(){
        setAnimal(new Animal(filePath + "/froggerUp.png"));
        getBackground().add(getAnimal());
    }

//    public void setBird(){
//        getBackground().add(new bird(filePath + "/bird1.com.png", 250, 440, -5, 50, 50));
//    }
////
    public void setLogs(){
        getBackground().add(new Log(filePath + "/log3.png", 150, 0, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 220, 166, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 440, 166, 0.75));

        getBackground().add(new Log(filePath + "/logs.png", 300, 0, 276, -2));
        getBackground().add(new Log(filePath + "/logs.png", 300, 400, 276, -2));

        getBackground().add(new Log(filePath + "/log3.png", 150, 50, 329, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 270, 329, 0.75));
        getBackground().add(new Log(filePath + "/log3.png", 150, 490, 329, 0.75));
    }

    public void setTurtle(){
        getBackground().add(new Turtle(500, 376, -1, 130, 130));
        getBackground().add(new Turtle(300, 376, -1, 130, 130));
    }

    public void setWetTurtle(){
        getBackground().add(new WetTurtle(700, 376, -1, 130, 130));
        getBackground().add(new WetTurtle(600, 217, -1, 130, 130));
        getBackground().add(new WetTurtle(400, 217, -1, 130, 130));
        getBackground().add(new WetTurtle(200, 217, -1, 130, 130));
    }

    public void setObstacle(){
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 0, 649, 1, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 300, 649, 1, 120, 120));
        getBackground().add(new Obstacle(filePath + "/truck1"+"Right.png", 600, 649, 1, 120, 120));

        getBackground().add(new Obstacle(filePath + "/car1Left.png", 100, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 250, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 400, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 550, 597, -1, 50, 50));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 0, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/truck2Right.png", 500, 540, 1, 200, 200));
        getBackground().add(new Obstacle(filePath + "/car1Left.png", 500, 490, -5, 50, 50));
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
}
