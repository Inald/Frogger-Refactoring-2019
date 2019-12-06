package com.mainPack.froggerGameObstacles;

import javafx.scene.image.Image;

public class Log extends Moving {

	private double speed;
	@Override
	public void act(long now) {
		super.movingObj(-180,-300,700, speed);
	}

	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
