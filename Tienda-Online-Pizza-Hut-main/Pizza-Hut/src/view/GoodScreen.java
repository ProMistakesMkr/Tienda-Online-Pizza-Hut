package view;

import processing.core.PApplet;

public class GoodScreen extends ScreenMaster {
	private int change=7;

	/**Constructor
	 * @param posY
	 * @param app
	 */
	public GoodScreen(float posY, PApplet app) {
		super(posY, app);
		// TODO Auto-generated constructor stub
		screen = app.loadImage("Pantalla Pago Exitoso.png");
	}
public void button() {
		
		System.out.println("presionado total");
		if (app.mouseX > 647 && app.mouseX < 647 + 137
				&& app.mouseY > 40 && app.mouseY < 40 + 19) { // 	InitialScreen Button 
			change = 0;
		}
		if (app.mouseX > 825 && app.mouseX < 825 + 65
				&& app.mouseY > 40 && app.mouseY < 40 + 19) { // 	Contacts Button
			change = 3;
		}
		if (app.mouseX > 975 && app.mouseX < 975 + 45
				&& app.mouseY > 40 && app.mouseY < 40 + 19) { // Login Button
			change = 1;
		}
		if (app.mouseX > 1096 && app.mouseX < 1096 + 82
				&& app.mouseY > 40 && app.mouseY < 40 + 19) { // Register
			change = 2;
		}
		if (app.mouseX > 390 && app.mouseX < 390 + 96
				&& app.mouseY > 503 && app.mouseY < 503 + 26) { // Register
			change = 0;
		}
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
}
