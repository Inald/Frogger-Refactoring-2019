package com.mainPack;

import javafx.scene.image.Image;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Constructor for digit takes the value of the parameters
	 * and sets a new image for the digit to be displayed in either
	 * Frogger lives or the number of points the user has
	 * @param n
	 * @param dim
	 * @param x
	 * @param y
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image(filePath + "/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
