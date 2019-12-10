package com.mainPack.World;

import java.io.File;

import com.mainPack.World.World;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World {
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}

	/**
	 * Constructor of MyStage class
	 */
	public MyStage() {

	}

	/**
	 * Function takes the file path of the music file in resources
	 * creates a new media player object and plays the music in the background
	 * of the game
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Music stops playing when function is called
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
