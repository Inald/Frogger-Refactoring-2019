package com.mainPack.froggerGameObjects;

import javafx.scene.image.Image;

/**
 * Creates logs in the game
 */
public class Log extends Moving {

	private double speed;

	/**
	 * Calls the super class movingObj to set the direction of which
	 * the log moves in
	 * @param now
	 */
	@Override
	public void act(long now) {
		super.movingObj(-180,-300,700, speed);
	}

	/**
	 * Constructor for the log class, parameters passed in for object
	 * creation and image of log is set
	 * @param imageLink
	 * @param size
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}

	/**
	 * Returns the true or false based on the value of the speed
	 * of the log
	 * @return
	 */
	public boolean getLeft() {
		return speed < 0;
	}

	/**
	 * Returns the speed of the log
	 * @return
	 */
	public double getSpeed() {
		return speed;
	}
}
