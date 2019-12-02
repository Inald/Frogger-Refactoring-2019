package com.mainPack;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//multiple levels can be added
<<<<<<< HEAD
		//startMenu menu = new startMenu(primaryStage);
		firstLevel newLevel = new firstLevel(primaryStage);
=======
		startMenu menu = new startMenu(primaryStage);
		//firstLevel newLevel = new firstLevel(primaryStage);
>>>>>>> startMenu
	}

	}

