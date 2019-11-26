import javafx.scene.image.Image;

public class WetTurtle extends Turtle{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
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
				} else if (now/nineHundredMillion %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos,ypos,s,w,h);
		turtle1 = new Image(filePath + "/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(filePath + "/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image(filePath + "/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image(filePath + "/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
