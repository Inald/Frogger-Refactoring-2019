package com.mainPack.froggerGameObjects;

import com.mainPack.World.World;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * Abstract class in which objects in the game subclass
 * and use methods in order to aid movement and checking
 * intersections.
 */
public abstract class Actor extends ImageView{

    /**
     * Value by which the activation timer is
     * divided by in the classes which extend Actor
     */
    protected final int nineHundredMillion = 900000000;

    /**
     * file path of where images are stored
     */
    protected String filePath = "file:src/main/resources";

    /**
     * Moves the object by the specified amount in
     * the parameters
     * @param dx
     * @param dy
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }


    /**
     * Returns the Parent class by casting it
     * to world
     * @return
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * returns the width of the Actor that
     * uses the method
     * @return
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Returns the height of the Actor that uses
     * the method
     * @return
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Checks that more than two Actors are intersecting with each
     * other
     * @param cls
     * @param <A>
     * @return
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    /**
     * Checks that two actors are not in the same position as each other
     * or that their boundaries aren't touching
     * @param cls
     * @param <A>
     * @return
     */
    public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
