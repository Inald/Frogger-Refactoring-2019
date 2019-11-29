package com.mainPack;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ getAnimal().getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
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