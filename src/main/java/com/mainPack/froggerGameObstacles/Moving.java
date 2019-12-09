package com.mainPack.froggerGameObstacles;

import com.mainPack.Actor;

public abstract class Moving extends Actor {

    private double speed;
    private double logSpeed;


    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Moving(){

    }

    /**
     * movingObj used to set the direction of the classes which extend it
     * - Log, WetTurtle, Turtle, Obstacle NOT RIGHT
     * @param set1
     * @param get1
     * @param set2
     * @param s
     */
    public void movingObj(int set1, int get1, int set2, double s){
        setSpeed(s);
        move(speed , 0);
        if (getX() > 600 && speed>0)
            setX(set1);
        if (getX() < get1 && speed<0)
            setX(set2);
    }



}
