package com.mainPack.froggerGameObstacles;

public class FactoryMoving {

    public FactoryMoving(){

    }

    public Moving getObject(String objType, String imageLink, int size, int xpos, int ypos, double s){
        if(objType.equals(null)){
            return null;
        }else if(objType.equalsIgnoreCase("LOG")) {
            return new Log(imageLink, size, xpos, ypos, s);
        }
        return null;
    }

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

