package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	int screen;
	PImage imgIni;// principal screen
	PImage imgReg; // register screen
	PImage imgCtlg;// catalogue
	PImage imgCs;// log out
	PImage imgPay; // pay
	PImage imgSpay;// successful pay
	PImage imgResu; // resume screen

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	public void settings() // void Awake
	{
		size(1440, 1024);
		screen = 0;
		
		imgIni = loadImage("Pantalla Inicio.png");
	    imgReg = loadImage("Pantalla Registro.png");
	    imgCtlg = loadImage("Pantalla Catalogo.png");
	    imgCs = loadImage("Cerrar Sesión.png");
	    imgPay = loadImage("Pantalla Pago.png");
	    imgSpay = loadImage("Pantalla Pago Exitoso.png");
	    imgResu = loadImage("Pantalla Resumen.png");
	    
	}

	public void setup() // void Start
	{

	}

	public void draw() {// void Update
	
		System.out.println(mouseX + "," + mouseY);
		switch (screen) {
		case 0: //Homescreen
			break;

		case 1: //pantalla de edicion de oso
			
		}	
	}

}
