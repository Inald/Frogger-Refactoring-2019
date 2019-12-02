package gameLevel;

import com.mainPack.froggerGameObstacles.Animal;
import com.mainPack.BackgroundImage;
import com.mainPack.Digit;
import com.mainPack.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public abstract class Levels{
    private AnimationTimer timer;
    private MyStage background;
    private Animal animal;

    protected String filePath = "file:src/main/resources";
    protected Scene scene;

    public void instantiateBackground(){
        setBackground(new MyStage());
        scene = new Scene(getBackground(), 600, 800);
        BackgroundImage froggerback = new BackgroundImage(filePath + "/iKogsKw.png");

        getBackground().add(froggerback);
    }

    public void createTimer() {
        String highScoreFile = filePath + "/highScores.txt";
        ArrayList<String> highScorePrint = new ArrayList<>();
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
                        BufferedWriter writer = new BufferedWriter(new FileWriter("highScores.txt", true));
                        writer.newLine();
                        writer.append(String.valueOf(getAnimal().getPoints()));
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //Reading from file
                    try{
                        BufferedReader read = new BufferedReader(new FileReader("highScores.txt"));
                        String highScoreLine;
                        int i = 0;
                        while((highScoreLine = read.readLine()) != null){
                            highScorePrint.add(highScoreLine);
                            //System.out.println(highScorePrint.get(i));
                            i++;
                        }
                        read.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    //bubble sort to print highest scores first



                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ getAnimal().getPoints()+"!");

                    StringBuffer stringBuf = new StringBuffer();
                    for(int j = 0; j < highScorePrint.size() - 1; j++){
                        stringBuf.append(highScorePrint.get(j) + "\n");
                    }

                    alert.setContentText("Highest Possible Score: 800\n" +
                            "High scores achieved by players:\n" +
                            stringBuf);


                    alert.show();
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
}
