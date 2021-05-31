package view;

import javax.swing.JOptionPane;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;

public class RegisterScreen extends ScreenManager {
	ControlP5 cp5;

	
	private String mail;
	private String pass;

	public RegisterScreen(PApplet app) {
		super(app);
		cp5 = new ControlP5(app);
	}

	@Override
	public void draw() {
		app.image(Register, 0, 0);

	}

	public void textFields() {

		cp5.addTextfield(".").setPosition(520, 429).setSize(285, 61).setFont(app.createFont("arial", 16))
				.setAutoClear(false).setColor(app.color(62, 36, 32)).setColorBackground(app.color(0, 0, 0, 1))
				.setColorForeground(app.color(0, 0, 0, 1)).getCaptionLabel().setColor(app.color(255, 235, 207));

		cp5.addTextfield("-").setPosition(516, 533).setSize(285, 61).setFont(app.createFont("arial", 16))
				.setAutoClear(false).setColor(app.color(62, 36, 32)).setColorBackground(app.color(0, 0, 0, 1))
				.setColorForeground(app.color(0, 0, 0, 1)).getCaptionLabel().setColor(app.color(255, 235, 207));

	}

	public void hide() {
		cp5.get(".").hide();
		cp5.get("-").hide();
	}

	public void show() {
		cp5.get(".").show();
		cp5.get("-").show();
	}

	public void clear() {
		cp5.get(Textfield.class, ".").clear();
		cp5.get(Textfield.class, "-").clear();
	}

	public void textfieldValues() {
		mail = cp5.get(Textfield.class, ".").getText();
		pass = cp5.get(Textfield.class, "-").getText();
	}

	public boolean isNull() {
		if (cp5.get(Textfield.class, ".").getText().trim().isEmpty()
				|| cp5.get(Textfield.class, "-").getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Woops",
					JOptionPane.ERROR_MESSAGE);
			return true;
		} else {
			return false;
		}
	}



	public String getMail() {
		return mail;
	}

	public String getPass() {
		return pass;
	}
}
