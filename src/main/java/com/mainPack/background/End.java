package com.mainPack.background;

import com.mainPack.froggerGameObjects.Actor;
import javafx.scene.image.Image;

/**
 * Sets the Ends of the game and contains methods stating
 * whether the end is full or not
 */
public class End extends Actor {
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * Constructor which passes in an x and y value
	 * to set the position of the ends in the game and set the image
	 * @param x
	 * @param y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(filePath + "/End.png", 60, 60, true, true));
	}

	/**
	 * Sets the ends to a new frog image to indicate that end has been
	 * reached and cannot be entered again
	 */
	public void setEnd() {
		setImage(new Image(filePath + "/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Returns the activated boolean variable to denote whether an end
	 * is already full
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
