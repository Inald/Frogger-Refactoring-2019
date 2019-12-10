package com.mainPack.background;

import com.mainPack.froggerGameObjects.Actor;
import javafx.scene.image.Image;

/**
 * Purpose of class is to set the background image
 * of the game
 */
public class BackgroundImage extends Actor {

	private static BackgroundImage instance;

	@Override
	public void act(long now) {
		
	}

	/**
	 * Instance of background image is created if one has not already
	 * been	instantiated and is returned. This allows for the singleton
     * design pattern
	 * @param imageLink
	 * @return
	 */
	public static BackgroundImage getInstance(String imageLink){
		if(instance == null){
			return new BackgroundImage(imageLink);
		}
		return instance;
	}

	/**
	 * Constructor takes the image path parameter and displays it in
	 * displayImage()
	 * @param imageLink
	 */
	private BackgroundImage(String imageLink) {
		this.displayImage(imageLink);
	}

	/**
	 * Sets the image of the background
	 * @param imageLink
	 */
	private void displayImage(String imageLink){
		setImage(new Image(imageLink, 600, 800, false, true));
	}

}
