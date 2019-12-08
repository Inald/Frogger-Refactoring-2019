package com.mainPack.froggerGameObstacles;

import javafx.scene.image.Image;

public class Obstacle extends Moving {
	private int speed;
	@Override
	public void act(long now) {
//		move(speed , 0);
//		if (getX() > 600 && speed>0)
//			setX(-200);
//		if (getX() < -50 && speed<0)
//			setX(600);
		super.movingObj(-200,-50,600, speed);
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
