package view;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class ScreenManager {
	protected PApplet app;
	  PImage Login,Register,Home,ExtrasMarga,ExtrasVege,ExtrasCheese,ExtrasChampi,Resumen,Pago,History;
	  public ScreenManager(PApplet app) {
		  this.app = app;
		  Login = app.loadImage ("img/PantallaLogIn.png");
		  Register = app.loadImage ("img/PantallaRegistro.png");
		  Home = app.loadImage ("img/PantallaInicio.png");
		  ExtrasMarga = app.loadImage ("img/PantallaMargarita.png");
		  ExtrasVege = app.loadImage ("img/PantallaVegetariana.png");
		  ExtrasCheese = app.loadImage ("img/PantallaCheese.png");
		  ExtrasChampi = app.loadImage ("img/PantallaChampiñon.png");
		  Resumen = app.loadImage ("img/PantallaResumen.png");
		  Pago = app.loadImage ("img/PantallaPago.png");
		  History = app.loadImage ("img/History.png");
	  }
	  public abstract void draw ();
}