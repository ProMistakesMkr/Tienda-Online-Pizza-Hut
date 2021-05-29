package view;

import processing.core.PApplet;
import processing.core.PImage;

public class ScreenMaster {
	protected float posY;
	protected PImage screen;
	protected PApplet app;
	
	public ScreenMaster (float posY, PApplet app) {
		this.posY=posY;
		this.screen=screen;
		this.app=app;
	}
	
	protected void drawImage() {
		app.image(screen, 0, posY);
	}
}
