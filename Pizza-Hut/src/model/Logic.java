package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import view.AddExtraScreen;
import view.PaymentScreen;
import view.CatalogScreen;
import view.LogInScreen;
import view.OrderHistory;
import view.OrderHistory;
import view.OrderSummary;
import view.OrderSummary;
import view.PaymentScreen;
import view.RegisterScreen;

public class Logic {
	private PApplet app;
	private PFont font1;
	private PFont font2;
	private int screen;
	private LogInScreen login;
	private RegisterScreen register;
	private CatalogScreen home;
	private AddExtraScreen extra;
	private PaymentScreen pay;
	private OrderSummary summary;
	private OrderHistory history;
	private boolean validPay;
	private boolean addCoke;
	private boolean addColombiana;
	private boolean addChocoRoll;
	private boolean addCookiePie;
	private boolean chooseMargarita;
	private boolean chooseChampi;
	private boolean chooseveg;
	private boolean chooseCheese;
	private Date date;
	private SimpleDateFormat datePrintter;
	private boolean loginSucc;
	private PImage coke, colombiana, chocoRoll, cookiePie;
	private ArrayList<User> userList;
	private DateApplier dateComp;

	public Logic(PApplet app) {
		this.app = app;
		font1 = app.createFont("arial", 20);
		// font2 = app.createFont("arial", 15);
		screen = 1;
		login = new LogInScreen(app);
		register = new RegisterScreen(app);
		home = new CatalogScreen(app);
		extra = new AddExtraScreen(app);
		pay = new PaymentScreen(app);
		summary = new OrderSummary(app);
		history = new OrderHistory(app);
		validPay = false;
		addCoke = false;
		addColombiana = false;
		addChocoRoll = false;
		addCookiePie = false;
		chooseMargarita = false;
		chooseChampi = false;
		chooseveg = false;
		chooseCheese = false;
		date = new Date();
		datePrintter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		loginSucc = false;

		coke = app.loadImage("img/PantallaCoca.png");
		colombiana = app.loadImage("img/PantallaColo.png");
		chocoRoll = app.loadImage("img/PantallaChoco.png");
		cookiePie = app.loadImage("img/PantallaCook.png");

		login.textFields();
		register.textFields();
		register.hide();

		userList = new ArrayList<User>();
	}

	public void changeScreen() {

		switch (screen) {
		case 1:
			login.draw();
			break;
		case 2:
			register.draw();
			break;
		case 3:
			home.draw();

			break;
		case 4:
			extra.draw();

			if (addCoke) {
				app.image(coke, 0, 0);
			}

			if (addColombiana) {
				app.image(colombiana, 0, 0);
			}

			if (addChocoRoll) {
				app.image(chocoRoll, 0, 0);
			}

			if (addCookiePie) {
				app.image(cookiePie, 0, 0);
			}

			if (validPay) {
				pay.draw();
			}
			break;
		case 5:
			summary.draw();

			// Texto grande
			app.textFont(font1);
			app.fill(62, 36, 32);

			app.text(userList.get(0).getOrderList().size() - 1, 121, 57);

			app.text((userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).getOrderDate()
					.toString()), 65, 495);

			app.text("$"
					+ userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).calculateTotal(),
					257, 655);

			// Texto peque?o
			app.textFont(font2);
			app.fill(62, 36, 32);

			app.text("Pedido: "
					+ userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).getDishName()
					+ "     $"
					+ userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).getDishPrice(), 85,
					565);
			app.text("Extra 1: "
					+ userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).getExtra(0)
							.getExtraName()
					+ "     $" + userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1)
							.getExtra(0).getExtraPrice(),
					85, 590);
			app.text("Extra 2: "
					+ userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1).getExtra(1)
							.getExtraName()
					+ "     $" + userList.get(0).getOrderList().get(userList.get(0).getOrderList().size() - 1)
							.getExtra(1).getExtraPrice(),
					85, 615);

			break;
		case 6:
			history.draw();
			
			for (int i = 1; i < userList.get(0).getOrderList().size(); i++) {
				app.text(
						"Pedido #" + i + " - " + "$" + userList.get(0).getOrderList().get(i).getOrderTotal() + "\n"
								+ datePrintter.format(userList.get(0).getOrderList().get(i).getOrderDate()),
						138, 130 + (88 * (i - 1)));
			}
			break;

		}
	}

	public void mousePressed() {
		switch (screen) {
		case 1:
			
			if ((712 < app.mouseX && app.mouseX < 1030) && (177 < app.mouseY && app.mouseY < 237)) {
				screen = 2;
				login.clear();
				login.hide();
				register.show();

			}
			
			if ((516 < app.mouseX && app.mouseX < 937) && (651 < app.mouseY && app.mouseY < 700)) {
				login.textfieldValues();
				for (int i = 0; i < userList.size(); i++) {
					if ((userList.get(i).getEmail().equals(login.getMail()))
							&& (userList.get(i).getPassword().equals(login.getPass()))) {
						screen = 3;
						login.clear();
						login.hide();
						loginSucc = true;
						userList.get(0).newOrder("XXXXXX", date, 8000000, 0);
					}
				}
				if (!loginSucc) {
					JOptionPane.showMessageDialog(null, "User not registered", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			break;
		case 2:
			
			if ((398 < app.mouseX && app.mouseX < 703) && (189 < app.mouseY && app.mouseY < 232)) {
				screen = 1;
				register.clear();
				register.hide();
				login.show();
			}
		
			if ((515 < app.mouseX && app.mouseX < 934) && (650 < app.mouseY && app.mouseY < 700)) {
				if (!register.isNull()) {
					register.textfieldValues();
					registerUser();
					screen = 1;
					register.clear();
					register.hide();
					login.show();
				}
			}
			break;
		case 3:
			// De Home a Margarita
			if ((143 < app.mouseX && app.mouseX < 392) && (324 < app.mouseY && app.mouseY < 742)) {
				extra.setExtraScreen(0);
				screen = 4;
				chooseMargarita = true;
				chooseveg = false;
				chooseChampi = false;
				chooseCheese = false;
			}
			// De Home a Champi
			if ((426 < app.mouseX && app.mouseX < 677) && (324 < app.mouseY && app.mouseY < 742)) {
				extra.setExtraScreen(1);
				screen = 4;
				chooseChampi = true;
				chooseveg = false;
				chooseCheese = false;
				chooseMargarita = false;
			}
			// De Home a Vegetariana
			if ((732 < app.mouseX && app.mouseX < 981) && (324 < app.mouseY && app.mouseY < 742)) {
				extra.setExtraScreen(2);
				screen = 4;
				chooseveg = true;
				chooseChampi = false;
				chooseCheese = false;
				chooseMargarita = false;
			}
			// De Home a Queso
			if ((1045 < app.mouseX && app.mouseX < 1300) && (324 < app.mouseY && app.mouseY < 742)) {
				extra.setExtraScreen(3);
				screen = 4;
				chooseCheese = true;
				chooseChampi = false;
				chooseveg = false;
				chooseMargarita = false;
			}
			
		case 4:
			
			if ((57 < app.mouseX && app.mouseX < 300) && (20 < app.mouseY && app.mouseY < 78)) {
				screen = 3;
				addCoke = false;
				addColombiana = false;
				addChocoRoll = false;
				addCookiePie = false;
				chooseMargarita = false;
				chooseChampi = false;
				chooseveg = false;
				chooseCheese = false;
			}
			// A?ade coke
			if ((351 < app.mouseX && app.mouseX < 697) && (582 < app.mouseY && app.mouseY < 728)) {
				if (!validPay) {
					addCoke = true;
					addColombiana = false;
				}
			}
			// A?ade colombiana
			if ((341 < app.mouseX && app.mouseX < 728) && (765 < app.mouseY && app.mouseY < 933)) {
				if (!validPay) {
					addColombiana = true;
					addCoke = false;
				}
			}
			// A?ade chocoroll
			if ((822 < app.mouseX && app.mouseX < 1257) && (601 < app.mouseY && app.mouseY < 732)) {
				if (!validPay) {
					addChocoRoll = true;
					addCookiePie = false;
				}
			}
			// A?ade cookiepie
			if ((823 < app.mouseX && app.mouseX < 1253) && (776 < app.mouseY && app.mouseY < 900)) {
				if (!validPay) {
					addCookiePie = true;
					addChocoRoll = false;
				}
			}
			// De Extra a Extra+Pay
			if (addCoke || addColombiana && addChocoRoll || addCookiePie) {
				if ((63 < app.mouseX && app.mouseX < 348) && (787 < app.mouseY && app.mouseY < 845)) {
					validPay = true;
				}
			}

			// De Extra+Pay a Summary
			if ((validPay) && (65 < app.mouseX && app.mouseX < 348) && (736 < app.mouseY && app.mouseY < 789)) {
				validPay = false;
				screen = 5;
				
				if (chooseMargarita) {
					date = new Date();
					userList.get(0).newOrder(".", date, 14000, 0);
				} 
				else if (chooseChampi) {
					date = new Date();
					userList.get(0).newOrder(".", date, 16000, 0);
				}
				
				else if (chooseveg) {
					date = new Date();
					userList.get(0).newOrder("..", date, 19000, 0);
				}
				
				else if (chooseCheese) {
					date = new Date();
					userList.get(0).newOrder(".", date, 15000, 0);
				}
				// Variable para siempre editar la ultima orden
				int lastPos = userList.get(0).getOrderList().size() - 1;

				// extras: coke y choco
				if (addCoke && addChocoRoll) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Coca-Cola", 5500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("Chocoroll", 4500);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: coke y cookiepie
				else if (addCoke && addCookiePie) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Coca-Cola", 5500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("CookiePie", 3000);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: Colombiana y Chocoroll
				else if (addColombiana && addChocoRoll) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Colombiana", 7500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("ChocoRoll", 4500);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: colombiana y cookiepie
				else if (addColombiana && addCookiePie) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Colombiana", 7500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("CookiePie", 3000);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

			}
			break;
		case 5:
			// De Summary a Home
			if ((63 < app.mouseX && app.mouseX < 348) && (755 < app.mouseY && app.mouseY < 814)) {
				screen = 3;
				addCoke = false;
				addColombiana = false;
				addChocoRoll = false;
				addCookiePie = false;
				chooseMargarita = false;
				chooseChampi = false;
				chooseveg = false;
				chooseCheese = false;
			}
			break;
		case 6:
			// Ordenar por valor
			if ((79 < app.mouseX && app.mouseX < 79 + 255) && (649 < app.mouseY && app.mouseY < 649 + 60)) {
				Collections.sort(userList.get(0).getOrderList());
				System.out.println("por valor");
			}
			// Ordenar por fecha
			if ((79 < app.mouseX && app.mouseX < 79 + 255) && (726 < app.mouseY && app.mouseY < 726 + 60)) {
				Collections.sort(userList.get(0).getOrderList(), dateComp);
				System.out.println("por fecha");
			}
			// De History a Home
			if ((92 < app.mouseX && app.mouseX < 117) && (830 < app.mouseY && app.mouseY < 857)) {
				screen = 3;
			}
			// De History a Login (Cerrar sesion)
			if ((296 < app.mouseX && app.mouseX < 320) && (830 < app.mouseY && app.mouseY < 857)) {
				screen = 1;
				login.show();
			}
			break;
		}
	}

	public void registerUser() {

		userList.add(new User(register.getMail(), register.getPass()));

	}

	public void logUser() {

	}
}
