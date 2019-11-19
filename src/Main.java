import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    setBackground(new MyStage());
	    Scene scene  = new Scene(getBackground(),600,800);
	    
		//Obstacle obstacle = new Obstacle("file:resources/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:resources/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:resources/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage("file:resources/iKogsKw.png");
	    
		getBackground().add(froggerback);
		
		getBackground().add(new Log("file:resources/log3.png", 150, 0, 166, 0.75));
		getBackground().add(new Log("file:resources/log3.png", 150, 220, 166, 0.75));
		getBackground().add(new Log("file:resources/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:resources/log3.png", 150, 0, 166, 0.75));
		getBackground().add(new Log("file:resources/logs.png", 300, 0, 276, -2));
		getBackground().add(new Log("file:resources/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:resources/logs.png", 300, 800, 276, -2));
		getBackground().add(new Log("file:resources/log3.png", 150, 50, 329, 0.75));
		getBackground().add(new Log("file:resources/log3.png", 150, 270, 329, 0.75));
		getBackground().add(new Log("file:resources/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:resources/log3.png", 150, 570, 329, 0.75));
		
		getBackground().add(new Turtle(500, 376, -1, 130, 130));
		getBackground().add(new Turtle(300, 376, -1, 130, 130));
		getBackground().add(new WetTurtle(700, 376, -1, 130, 130));
		getBackground().add(new WetTurtle(600, 217, -1, 130, 130));
		getBackground().add(new WetTurtle(400, 217, -1, 130, 130));
		getBackground().add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:resources/log2.png", 200, 100, 1));
		//background.add(new Log("file:resources/log2.png", 0, 100, 1));
		//background.add(new Log("file:resources/log2.png", 100, 120, -1));
		//background.add(new Log("file:resources/log2.png", 200, 120, -1));
		//background.add(new Log("file:resources/log2.png", 100, 140, 1));
		//background.add(new Log("file:resources/log2.png", 200, 140, 1));
		//background.add(new Log("file:resources/log2.png", 100, 160, -1));
		//background.add(new Log("file:resources/log2.png", 300, 160, -1));
		//background.add(new Log("file:resources/log2.png", 100, 180, 1));
		//background.add(new Log("file:resources/log2.png", 200, 180, 1));
		//background.add(new Log("file:resources/log2.png", 100, 200, -1));
		//background.add(new Log("file:resources/log2.png", 200, 200, -1));
		//background.add(new Log("file:resources/log2.png", 100, 220, 1));
		//background.add(new Log("file:resources/log2.png", 200, 220, 1));
		//background.add(new Log("file:resources/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		getBackground().add(new End(13,96));
		getBackground().add(new End(141,96));
		getBackground().add(new End(141 + 141-13,96));
		getBackground().add(new End(141 + 141-13+141-13+1,96));
		getBackground().add(new End(141 + 141-13+141-13+141-13+3,96));
		setAnimal(new Animal("file:resources/froggerUp.png"));
		getBackground().add(getAnimal());
		getBackground().add(new Obstacle("file:resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
		getBackground().add(new Obstacle("file:resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
		getBackground().add(new Obstacle("file:resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:resources/truck1"+"Right.png", 720, 649, 1, 120, 120));
		getBackground().add(new Obstacle("file:resources/car1Left.png", 100, 597, -1, 50, 50));
		getBackground().add(new Obstacle("file:resources/car1Left.png", 250, 597, -1, 50, 50));
		getBackground().add(new Obstacle("file:resources/car1Left.png", 400, 597, -1, 50, 50));
		getBackground().add(new Obstacle("file:resources/car1Left.png", 550, 597, -1, 50, 50));
		getBackground().add(new Obstacle("file:resources/truck2Right.png", 0, 540, 1, 200, 200));
		getBackground().add(new Obstacle("file:resources/truck2Right.png", 500, 540, 1, 200, 200));
		getBackground().add(new Obstacle("file:resources/car1Left.png", 500, 490, -5, 50, 50));
		getBackground().add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		getBackground().start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}


	public void createTimer() {
        setTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (getAnimal().changeScore()) {
            		setNumber(getAnimal().getPoints());
            	}
            	if (getAnimal().getStop()) {
            		System.out.print("STOPP:");
            		getBackground().stopMusic();
            		stop();
            		getBackground().stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+ getAnimal().getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        });
    }
	public void start() {
		getBackground().playMusic();
    	createTimer();
        getTimer().start();
    }

    public void stop() {
        getTimer().stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getBackground().add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }

	public AnimationTimer getTimer() {
		return timer;
	}

	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

	public MyStage getBackground() {
		return background;
	}

	public void setBackground(MyStage background) {
		this.background = background;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
