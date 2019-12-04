package com.mainPack.froggerGameObstacles;

import javafx.scene.image.Image;

public class bird extends moving {

    private double speed;

    @Override
    public void act(long now) {
        super.movingObj(-200, 50, 600, speed);
    }

    public bird(String imageLink, int xpos, int ypos, int s, int w, int h){
        setImage(new Image(imageLink, w, h, true, true));
        setX(xpos);
        setY(ypos);
        speed = s;
    }
}
