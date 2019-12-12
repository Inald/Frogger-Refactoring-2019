package com.mainPack.froggerGameObjects;

import javafx.scene.image.Image;

/**
 * Class creates the obstacles in the game
 */
public class Obstacle extends Moving{
	private int speed;

	/**
	 * Calls the super class movingObj to set the direction of which
	 * the log moves in
	 * @param now
	 */
	@Override
	public void act(long now) {
		super.movingObj(-200,-50,600, speed);
	}

	public int getSpeed() {
		return speed;
	}

	/**
	 * Constructor of Obstacle class, uses parameters to set a new image
	 * and the position of the image
	 * @param imageLink
	 * @param xpos
	 * @param ypos
	 * @param s
	 * @param w
	 * @param h
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
