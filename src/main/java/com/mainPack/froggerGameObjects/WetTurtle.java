package com.mainPack.froggerGameObjects;

/**
 * Class creates the WetTurtles in the game
 */
public class WetTurtle extends Turtle {
	int i = 1;
	boolean bool = true;
	boolean sunk = false;

	/**
	 * Checks the state of the WetTurtle by dividing by
	 * nineHundredMillion and after performing modulo 4 to see
	 * the state of the WetTurtle e.g. sunk or not
	 * @param now
	 */
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

		super.movingObj(-200,-75,600, getSpeed());
	}

	/**
	 * Constructor WetTurtle performs the method of the constructor
	 * in the super class and sets the images of WetTurtle
	 * @param xpos
	 * @param ypos
	 * @param s
	 * @param w
	 * @param h
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s,w,h);
		turtle1 = setTurtle1(w,h);
		turtle2 = wetTurtle2(w,h);
		turtle3 = wetTurtle3(w,h);
		turtle4 = wetTurtle4(w,h);

	}

	/**
	 * Returns true of false depending on if the Turtle is sunk
	 * or not
	 * @return
	 */
	public boolean isSunk() {
		return sunk;
	}
}
