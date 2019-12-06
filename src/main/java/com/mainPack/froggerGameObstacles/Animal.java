package com.mainPack.froggerGameObstacles;

import java.util.ArrayList;
import java.util.Collections;

import com.mainPack.Actor;
import com.mainPack.End;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int finalRoundPoints = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	int frogLives = 3;
	int roundScore;
	Alert alert;
	ArrayList<End> inter = new ArrayList<End>();
	ArrayList<Integer> roundPoints = new ArrayList<>();



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
					if (getY() < w) {
						w = getY();
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
	
	@Override
	public void act(long now) {
		int bounds = 0;

		if(getFrogLives() == 0){
			getStop();
		}

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
				move(-2,0 ); //changes speed of frogs movement on log - need to store a value from when its set to put in here.
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
				//minusFroggerLife();
			} else {
				move(-1,0); //changes speed of frog on wet turtle
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0); //changes speed of frog on turtle
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				//waterDeath = true; not sure about this as can go to same end mulitple times
				end--;
				minusPoints(50);
			}
			addPoints(50);
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
			roundScore = scoreForRound();
			finalRoundPoints = getPoints();
			roundPoints.add(roundScore);
			roundPoints(getPoints(), roundPoints);
		}
		else if (getY()<413){
			waterDeath = true;

			//setX(300);
			//setY(679.8+movement);
		}
	}
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


	public void customDesign(){
		DialogPane customPane = alert.getDialogPane();
		customPane.getStylesheets().add(filePath + "/startScreenCustom.css");
		customPane.getStyleClass().add("dialogWriting");
		customPane.getStyleClass().add("Dialog");
		customPane.getStyleClass().add("dialogHeader");
		customPane.getStyleClass().add("dialogTopLabel");
	}


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

	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void addPoints(int points){
		this.points += points;
		changeScore = true;
	}

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

	public boolean isWaterDeath()
	{
		return waterDeath;
	}

	public boolean isCarDeath()
	{
		return carDeath;
	}

	public int minusFroggerLife(){
		if(frogLives == 0){
			getStop();
		}
		return frogLives -= 1;
	}

	public int getFrogLives() {
		return frogLives;
	}
}
