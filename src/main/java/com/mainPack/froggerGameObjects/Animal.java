package com.mainPack.froggerGameObjects;

import java.util.ArrayList;
import java.util.Collections;

import com.mainPack.background.End;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Creates and positions the frog and checks the state of the game
 * as the frog moves throughout the game until the number of ends = 5
 * or the frog lives have run out
 */
public class Animal extends Actor {
	/**
	 * Image initialised globally here so it can be accesed
	 * and set by methods
	 */
	Image imgW1;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgA1;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgS1;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgD1;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgW2;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgA2;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgS2;
	/**
	 * Image initialised globally here so it can be accessed
	 * and set by methods
	 */
	Image imgD2;
	/**
	 * User's points for the game
	 */
	int points = 0;

	/**
	 * User's points for the round
	 */
	int finalRoundPoints = 0;

	/**
	 * Number of ends full is 0 to begin with,
	 * incremented by 1 each time the frog enters
	 * one of the ends
	 */
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	/**
	 * Movement of the frog in the Y direction
	 */
	double movement = 13.3333333*2;

	/**
	 * Movement of the frog in the X direction
	 */
	double movementX = 10.666666*2;

	/**
	 * Size of the images set
	 */
	int imgSize = 40;

	/**
	 * Boolean to store true or false
	 * if frog is killed by obstacles
	 */
	boolean carDeath = false;

	/**
	 * Boolean to store true or false
	 * if frog is killed by the water
	 */
	boolean waterDeath = false;
	boolean stop = false;

	/**
	 * Variable changes depending on when the
	 * score updates
	 */
	boolean changeScore = false;

	int carD = 0;

	/**
	 * Used to track the furthest Y reached so that it does not
	 * add points if user retreats and goes up again
	 */
	double furthestY = 800;
	/**
	 * Number of frog lives
	 */
	int frogLives = 3;
	/**
	 * Score for the round
	 */
	int roundScore;
	Alert alert;


	ArrayList<End> inter = new ArrayList<End>();

	/**
	 * ArrayList of points scored for each round player
	 */
	ArrayList<Integer> roundPoints = new ArrayList<>();


	/**
	 * Sets the position of the frog as well as the images of
	 * the frog once it is in different positions depending
	 * on the keys pressed and released
	 * @param imageLink
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image(filePath + "/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image(filePath + "/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image(filePath + "/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image(filePath + "/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image(filePath + "/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image(filePath + "/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image(filePath + "/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image(filePath + "/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < furthestY) {
						furthestY = getY();
						addPoints(10);
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}

	/**
	 * Sets the position of the frog and checks the frogs position throughout
	 * the game and changes its image depending on whether it is hit by an obstacle
	 * or dies in the water and also checks whether the end is full and if so does not
	 * allow the frog to go into the end that has already been activated
	 * @param now
	 */
	@Override
	public void act(long now) {
		int bounds = 0;


		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image(filePath + "/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image(filePath + "/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image(filePath + "/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				minusFroggerLife();
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image(filePath + "/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;

				minusPoints(50);


			}

		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image(filePath + "/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image(filePath + "/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image(filePath + "/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image(filePath + "/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				minusFroggerLife();
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image(filePath + "/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				minusPoints(50);

			}

		}

		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
			//minusFroggerLife();
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(getIntersectingObjects(Log.class).get(0).getSpeed(),0 ); //changes speed of frogs movement on log - need to store a value from when its set to put in here.
			else
				move (getIntersectingObjects(Log.class).get(0).getSpeed(),0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
				//minusFroggerLife();
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0); //changes speed of frog on wet turtle
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0); //changes speed of frog on turtle
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				//waterDeath = true; not sure about this as can go to same end mulitple times
				setY(getY() + (movement*2));
			}else {
				addPoints(50);
				furthestY = 800;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				setX(300);
				setY(679.8 + movement);
				roundScore = scoreForRound();
				finalRoundPoints = getPoints();
				roundPoints.add(roundScore);
				roundPoints(getPoints(), roundPoints);
			}
		}
		else if (getY()<413){
			waterDeath = true;

			//setX(300);
			//setY(679.8+movement);
		}
	}

	/**
	 * Finds out the score earned for the round
	 * that the user is playing, sees how it has changed
	 * compared to the overall score of the last round
	 * and returns it for the user to see
	 * @return
	 */
	public int scoreForRound(){
		int difference = 0;
		if(finalRoundPoints == 0){
			finalRoundPoints = getPoints();
			difference = finalRoundPoints;
		}else if(finalRoundPoints > getPoints()){
			difference = getPoints() - finalRoundPoints;
		}else if(finalRoundPoints < getPoints()){
			difference = getPoints() - finalRoundPoints;
		}
		return difference;
	}

	/**
	 * Function to call the CSS file and make
	 * the design of alerts appear as specified
	 * in the CSS file
	 */
	public void customDesign(){
		DialogPane customPane = alert.getDialogPane();
		customPane.getStylesheets().add(filePath + "/startScreenCustom.css");
		customPane.getStyleClass().add("dialogWriting");
		customPane.getStyleClass().add("Dialog");
		customPane.getStyleClass().add("dialogHeader");
		customPane.getStyleClass().add("dialogTopLabel");
	}


	/**
	 * Prints the score the user achieved for the round
	 * and displays the score of each round in the game
	 * in descending order (Highest to lowest)
	 * @param endPoints
	 * @param roundPoints
	 */
	public void roundPoints(int endPoints, ArrayList roundPoints){
		alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Highscore for round");
		customDesign();
		alert.setHeaderText("You've scored " + getPoints());
		Collections.sort(roundPoints);
		StringBuffer sb = new StringBuffer();


		for(int i = roundPoints.size() - 1; i >= 0; i--){
			sb.append(String.valueOf(roundPoints.get(i)) + "\n");
		}
		alert.setContentText("Highscore for each round: \n" +
				sb);
		alert.setHeight(600);
		alert.show();
	}

	/**
	 * Returns true or false to end the game based on whether
	 * the game is finished or the number of lives of the frog
	 * reached equals zero.
	 * @return
	 */
	public boolean getStop() {
		return end==5 || getFrogLives() == 0;
	}

	/**
	 * Returns the points
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the number of points the user has
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Adds the number of points passed into the function
	 * to the overall number of points and sets the changeScore
	 * variable to true to indicate a new score
	 * @param points
	 */
	public void addPoints(int points){
		this.points += points;
		changeScore = true;
	}

	/**
	 * Removes the number of points passed into the function
	 * from the overall number of points the and sets the
	 * changeScore variable to indicate a score change.
	 * @param points
	 */
	public void minusPoints(int points){
		if(getPoints() >= points) {
			this.points -= points;
		}else{
			setPoints(0);
		}
		changeScore = true;
	}


	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * Returns whether waterDeath is true or false
	 * @return
	 */
	public boolean isWaterDeath()
	{
		return waterDeath;
	}

	/**
	 * Returns whether carDeath is true or false
	 * @return
	 */
	public boolean isCarDeath()
	{
		return carDeath;
	}

	/**
	 * If frogger lives is 0 then calls getStop() to end
	 * the game otherwise returns frogLives after it has been
	 * decremented by 1
	 * @return
	 */
	public int minusFroggerLife(){
		if(frogLives == 0){
			getStop();
		}
		return frogLives -= 1;
	}

	/**
	 * Returns the number of frogLives
	 * @return
	 */
	public int getFrogLives() {
		return frogLives;
	}
}
