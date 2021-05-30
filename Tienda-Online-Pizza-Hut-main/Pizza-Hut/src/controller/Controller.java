package controller;


import controlP5.ControlP5;
import model.Logic;
import processing.core.PApplet;

public class Controller {
	Logic logic;
	private PApplet app ;
	private ControlP5 cp5;
	public Controller(PApplet app,ControlP5 cp5) {
		this.app=app;
		this.cp5=cp5;
		
		logic = new Logic(app);
		
	}
	public void changeScreen() {
		logic.changeScreen();
	}
	public void mousePressed() {
		logic.mousePressed();
	}
}