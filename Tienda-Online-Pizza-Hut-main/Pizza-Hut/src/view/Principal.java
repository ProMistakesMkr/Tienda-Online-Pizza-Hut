package view;
import controller.Controller;
import controller.ControllerMain;
import processing.core.PApplet;
public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main(Principal.class.getName());
		
	}
	
	@Override
	public void settings() {
		size(414,896);
	}
	
Controller controller;
	
	@Override
	public void setup() {
	controller = new Controller(this, null);
	}
	
	@Override
	public void draw() {
	controller.changeScreen();
	//System.out.println(mouseX+" "+mouseY);
	}
	public void mousePressed() {
		controller.mousePressed();
	}
}
