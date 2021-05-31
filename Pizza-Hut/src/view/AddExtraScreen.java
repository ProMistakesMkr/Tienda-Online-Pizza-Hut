package view;

import processing.core.PApplet;

public class AddExtraScreen extends ScreenManager {
	int extraScreen;
	 public AddExtraScreen(PApplet app) {
	        super(app);
	    }

	@Override
	public void draw() {
		//Cambios de pantallas segun la hamburguesa
		switch(extraScreen) {
		case 0:
			 app.image(ExtrasMarga,0,0);
		break;
		case 1:
			 app.image(ExtrasVege,0,0);
		break;
		case 2:
			 app.image(ExtrasCheese,0,0);
		break;
		case 3:
			 app.image(ExtrasChampi,0,0);
		break;
		}
		 
		
	}

	public void setExtraScreen(int extraScreen) {
		this.extraScreen = extraScreen;
	}

}
