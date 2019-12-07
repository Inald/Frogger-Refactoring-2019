package com.mainPack;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {

	private static BackgroundImage instance;

	@Override
	public void act(long now) {
		
	}

	public static BackgroundImage getInstance(String imageLink){
		if(instance == null){
			return new BackgroundImage(imageLink);
		}
		return instance;
	}
	
	private BackgroundImage(String imageLink) {
		this.displayImage(imageLink);
	}

	private void displayImage(String imageLink){
		setImage(new Image(imageLink, 600, 800, false, true));
	}

}
