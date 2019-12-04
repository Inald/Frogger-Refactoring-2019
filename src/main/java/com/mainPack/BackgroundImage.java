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
	
	public BackgroundImage(String imageLink) {
		this.displayImage(imageLink);
	}

	public void displayImage(String imageLink){
		setImage(new Image(imageLink, 600, 800, false, true));
	}

}
