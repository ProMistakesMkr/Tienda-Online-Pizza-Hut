package view;

import processing.core.PApplet;

public class PaymentScreen extends ScreenManager {
	 
	public PaymentScreen(PApplet app) {
	        super(app);
	    }

	@Override
	public void draw() {
		  app.image(Pago,0,0);
		
	}

}
