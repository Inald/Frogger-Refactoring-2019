package com.mainPack;

import javafx.scene.image.Image;

public class WetTurtle extends Turtle{
//	Image turtle1;
//	Image turtle2;
//	Image turtle3;
	Image turtle4;
	//private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/nineHundredMillion  % 4 ==0) {
					setImage(turtle2);
					sunk = false;

				}
				else if (now/nineHundredMillion % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/nineHundredMillion %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else
				if (now/nineHundredMillion %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed() > 0)
			setX(-200);
		if (getX() < -75 && getSpeed() < 0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s,w,h);
		turtle1 = getTurtle1(w,h);
		turtle2 = wetTurtle2(w,h);
		turtle3 = wetTurtle3(w,h);
		turtle4 = wetTurtle4(w,h);
//		setX(xpos);
//		setY(ypos);
//		speed = s;
//		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
