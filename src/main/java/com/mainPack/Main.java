package com.mainPack;

import gameLevel.firstLevel;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		startMenu menu = startMenu.getInstance(primaryStage);

	}

	}

