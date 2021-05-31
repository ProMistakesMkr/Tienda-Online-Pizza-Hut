package view;

import processing.core.PApplet;

public class OrderSummary extends ScreenManager {
	 
	public OrderSummary(PApplet app) {
	        super(app);
	    }

	@Override
	public void draw() {
		  app.image(Resumen,0,0);
		
	}

}
