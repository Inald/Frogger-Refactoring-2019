package com.mainPack;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;

	public int getSpeed() {
		return speed;
	}

	public Image getTurtle1(int w, int h) {
//		String turtle1Img;
		Image turtle1Img;
		turtle1Img = new Image(filePath + "/TurtleAnimation1.png", w, h, true, true);
		return turtle1Img;
	}

	public Image getTurtle2(int w, int h) {
		Image turtle2Img;
		turtle2Img = new Image(filePath + "/TurtleAnimation2.png", w, h, true, true);
		return turtle2Img;

	}

	public Image getTurtle3(int w, int h) {
		Image turtle3Img;
		turtle3Img = new Image(filePath + "/TurtleAnimation3.png", w, h, true, true);
		return turtle3Img;
	}

	public Image wetTurtle2(int w, int h){
		Image wetTurtle2Img;
		wetTurtle2Img = new Image(filePath + "/TurtleAnimation2Wet.png", w, h, true, true);
		return wetTurtle2Img;
	}

	public Image wetTurtle3(int w, int h){
		Image wetTurtle3Img;
		wetTurtle3Img = new Image(filePath + "/TurtleAnimation3Wet.png", w, h, true, true);
		return wetTurtle3Img;
	}

	public Image wetTurtle4(int w, int h){
		Image wetTurtle4Img;
		wetTurtle4Img = new Image(filePath + "/TurtleAnimation4Wet.png", w, h, true, true);
		return wetTurtle4Img;
	}




	@Override
	public void act(long now) {

		long stateOfTurtle = (now/nineHundredMillion % 3);

		if (stateOfTurtle == 0) {
			setImage(turtle2);
					
		}
		else if (stateOfTurtle == 1) {
			setImage(turtle1);
					
		}
		else if (stateOfTurtle == 2) {
			setImage(turtle3);
					
		}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}


	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = getTurtle1(w,h);
		turtle2 = getTurtle2(w,h);
		turtle3 = getTurtle3(w,h);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
