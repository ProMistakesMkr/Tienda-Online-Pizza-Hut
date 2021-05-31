package view;

import processing.core.PApplet;

public class OrderHistory extends ScreenManager {
	
	public OrderHistory (PApplet app) {
	        super(app);
	    }

	@Override
	public void draw() {
		  app.image(History,0,0);
		
	}

}
