package com.mainPack.froggerGameObstacles;

import javafx.scene.image.Image;

public class Turtle extends Moving {
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

	public Image setTurtle1(int w, int h) {
//		String turtle1Img;
		Image turtle1Img;
		turtle1Img = new Image(filePath + "/TurtleAnimation1.png", w, h, true, true);
		return turtle1Img;
	}

	public Image setTurtle2(int w, int h) {
		Image turtle2Img;
		turtle2Img = new Image(filePath + "/TurtleAnimation2.png", w, h, true, true);
		return turtle2Img;

	}

	public Image setTurtle3(int w, int h) {
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

		super.movingObj(-200,-75,600, speed);
	}


	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = setTurtle1(w,h);
		turtle2 = setTurtle2(w,h);
		turtle3 = setTurtle3(w,h);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
