package view;

import processing.core.PApplet;

public class CatalogScreen extends ScreenManager {
	 public CatalogScreen(PApplet app) {
	        super(app);
	    }

	@Override
	public void draw() {
		  app.image(Home,0,0);
		
	}

}
