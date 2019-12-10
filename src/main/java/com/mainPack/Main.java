package com.mainPack;

import com.mainPack.gameStart.StartMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Calls the instance of start menu, if one does not exist
	 * then it is created
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		StartMenu menu = StartMenu.getInstance(primaryStage);

	}

	}

