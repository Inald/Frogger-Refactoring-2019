package com.mainPack.froggerGameObstacles;

import com.mainPack.Actor;
import javafx.scene.image.Image;

public class Log extends moving {

	private double speed;
	@Override
	public void act(long now) {
//		move(speed , 0);
//		if (getX()>600 && speed>0)
//			setX(-180);
//		if (getX()<-300 && speed<0)
//			setX(700);
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
