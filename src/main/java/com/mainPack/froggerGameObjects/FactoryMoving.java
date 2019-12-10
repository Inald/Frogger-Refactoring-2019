package com.mainPack.froggerGameObjects;

/**
 * Purpose of class is due to Factory design pattern
 * used to set the objects in the game
 */
public class FactoryMoving {

    /**
     * Constructor of class
     */
    public FactoryMoving(){

    }

    /**
     * creates a log object and returns it,
     * if the correct String objType is passed in,
     * otherwise null is returned
     * @param objType
     * @param imageLink
     * @param size
     * @param xpos
     * @param ypos
     * @param s
     * @return
     */
    public Moving getObject(String objType, String imageLink, int size, int xpos, int ypos, double s){
        if(objType.equals(null)){
            return null;
        }else if(objType.equalsIgnoreCase("LOG")) {
            return new Log(imageLink, size, xpos, ypos, s);
        }
        return null;
    }

    /**
     * creates a Turtle, WetTurtle or obstacle based on
     * parameters passed in and returns it. Otherwise
     * null is returned
     * @param objType
     * @param imageLink
     * @param xpos
     * @param ypos
     * @param s
     * @param w
     * @param h
     * @return
     */
    public Moving getObject(String objType, String imageLink, int xpos, int ypos, int s, int w, int h){
        if(objType.equals(null)){
            return null;
        }
        if(imageLink.equals("")){
            if (objType.equalsIgnoreCase("TURTLE")){
                return new Turtle(xpos,ypos,s,w,h);
            }else if(objType.equalsIgnoreCase("WETTURTLE")){
                return new WetTurtle(xpos,ypos,s,w,h);
            }
        }else{
            if(objType.equalsIgnoreCase("OBSTACLE")){
                return new Obstacle(imageLink, xpos, ypos, s, w, h);
            }
        }
        return null;
    }
}

