package com.mainPack.froggerGameObstacles;

public class WetTurtle extends Turtle {
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
			
//		move(getSpeed() , 0);
//		if (getX() > 600 && getSpeed() > 0)
//			setX(-200);
//		if (getX() < -75 && getSpeed() < 0)
//			setX(600);
		super.movingObj(-200,-75,600, getSpeed());
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s,w,h);
		turtle1 = setTurtle1(w,h);
		turtle2 = wetTurtle2(w,h);
		turtle3 = wetTurtle3(w,h);
		turtle4 = wetTurtle4(w,h);

	}
	public boolean isSunk() {
		return sunk;
	}
}
