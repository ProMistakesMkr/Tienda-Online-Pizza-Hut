package view;

import processing.core.PApplet;
import processing.core.PImage;

public class FirstScreen extends ScreenMaster {

	private int change = 0;

	private int ticketOne = 0;
	private int ticketTwo = 0;
	private int ticketThree = 0;
	private boolean tOne = false;
	private boolean tTwo = false;
	private boolean tThree = false;

	public FirstScreen(int posY, PApplet app) {
		super(posY, app);
		screen = app.loadImage("Pantalla Inicio.png");

	}

	public void scrollPlus() {
		if (posY <= 0 && posY > -3960) {
			posY -= 30;
		}
		//public void scrollMinus() {
			//if (posY <0 && posY >=-3960) {
				//posY +=30;
				//System.out.println(posY);
			}
		//}
		
	}
//}
