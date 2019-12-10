package com.mainPack.World;

import java.util.ArrayList;
import java.util.List;

import com.mainPack.froggerGameObjects.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public abstract class World extends Pane {
    private AnimationTimer timer;

    /**
     * Constructor for world adds listener and updates the
     * scene according to the key's pressed and released
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

            /**
             * Modifies the scene by updating
             * @param observable
             * @param oldValue
             * @param newValue
             */
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

                        /**
                         * Sets up and takes key released and deals with it appropriately
                         * by performing the event
                         * @param event
                         */
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

                        /**
                         * Sets up and takes the keypress
                         * and deals with it appropriately
                         * by peforming the event
                         * @param event
                         */
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * Creates a new animation timer and calls act
     * on the actors stored in the list
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Creates the timer and starts running
     * it
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stops the timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Adds Actors to the game
     * @param actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Removes actors from the game
     * @param actor
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Creates a new array of all the objects
     * that are apart of world
     * @param cls
     * @param <A>
     * @return
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
