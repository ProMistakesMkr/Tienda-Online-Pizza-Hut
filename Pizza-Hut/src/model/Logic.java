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
import view.HomeScreen;
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
	private boolean addChips;
	private boolean addOnionRings;
	private boolean addCheese;
	private boolean addSuero;
	private boolean chooseCorral;
	private boolean chooseCheese;
	private boolean chooseBacon;
	private boolean chooseChicken;
	private Date date;
	private SimpleDateFormat datePrintter;
	private boolean loginSucc;
	private PImage chips, onionRings, cheese, suero;
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
		addChips = false;
		addOnionRings = false;
		addCheese = false;
		addSuero = false;
		chooseCorral = false;
		chooseCheese = false;
		chooseBacon = false;
		chooseChicken = false;
		date = new Date();
		datePrintter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		loginSucc = false;

		chips = app.loadImage("img/chips.png");
		onionRings = app.loadImage("img/Onion Rings.png");
		cheese = app.loadImage("img/Cheese.png");
		suero = app.loadImage("img/Suero.png");

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

			if (addChips) {
				app.image(chips, 0, 0);
			}

			if (addOnionRings) {
				app.image(onionRings, 0, 0);
			}

			if (addCheese) {
				app.image(cheese, 0, 0);
			}

			if (addSuero) {
				app.image(suero, 0, 0);
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

			// Texto pequeño
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
			// Lista de pedidos
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
			// De Login a Register
			if ((712 < app.mouseX && app.mouseX < 1030) && (177 < app.mouseY && app.mouseY < 237)) {
				screen = 2;
				login.clear();
				login.hide();
				register.show();

			}
			// De Login a Home
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
			// De Register a Login "Iniciar sesión"
			if ((398 < app.mouseX && app.mouseX < 703) && (189 < app.mouseY && app.mouseY < 232)) {
				screen = 1;
				register.clear();
				register.hide();
				login.show();
			}
			// De Register a Login "Registrarse"
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
			// De Home a Corral
			if ((48 < app.mouseX && app.mouseX < 365) && (207 < app.mouseY && app.mouseY < 321)) {
				extra.setExtraScreen(0);
				screen = 4;
				chooseCorral = true;
				chooseBacon = false;
				chooseCheese = false;
				chooseChicken = false;
			}
			// De Home a Corral Queso
			if ((48 < app.mouseX && app.mouseX < 365) && (354 < app.mouseY && app.mouseY < 467)) {
				extra.setExtraScreen(1);
				screen = 4;
				chooseCheese = true;
				chooseBacon = false;
				chooseChicken = false;
				chooseCorral = false;
			}
			// De Home a Corral Tocineta
			if ((48 < app.mouseX && app.mouseX < 365) && (500 < app.mouseY && app.mouseY < 613)) {
				extra.setExtraScreen(2);
				screen = 4;
				chooseBacon = true;
				chooseCheese = false;
				chooseChicken = false;
				chooseCorral = false;
			}
			// De Home a Corral Pollo
			if ((48 < app.mouseX && app.mouseX < 365) && (646 < app.mouseY && app.mouseY < 760)) {
				extra.setExtraScreen(3);
				screen = 4;
				chooseChicken = true;
				chooseCheese = false;
				chooseBacon = false;
				chooseCorral = false;
			}
			// De Home a History
			if ((195 < app.mouseX && app.mouseX < 215) && (830 < app.mouseY && app.mouseY < 857)) {
				screen = 6;
			}
			// De Home a Login (Cerrar sesion)
			if ((296 < app.mouseX && app.mouseX < 320) && (830 < app.mouseY && app.mouseY < 857)) {
				screen = 1;
				login.show();
			}
			break;
		case 4:
			// De Extra a Home
			if ((37 < app.mouseX && app.mouseX < 57) && (94 < app.mouseY && app.mouseY < 106)) {
				screen = 3;
				addChips = false;
				addOnionRings = false;
				addCheese = false;
				addSuero = false;
				chooseCorral = false;
				chooseCheese = false;
				chooseBacon = false;
				chooseChicken = false;
			}
			// Añade papitas
			if ((39 < app.mouseX && app.mouseX < 376) && (415 < app.mouseY && app.mouseY < 469)) {
				if (!validPay) {
					addChips = true;
					addOnionRings = false;
				}
			}
			// Añade anillos de cebolla
			if ((39 < app.mouseX && app.mouseX < 376) && (487 < app.mouseY && app.mouseY < 541)) {
				if (!validPay) {
					addOnionRings = true;
					addChips = false;
				}
			}
			// Añade queso
			if ((39 < app.mouseX && app.mouseX < 376) && (605 < app.mouseY && app.mouseY < 659)) {
				if (!validPay) {
					addCheese = true;
					addSuero = false;
				}
			}
			// Añade suero
			if ((39 < app.mouseX && app.mouseX < 376) && (677 < app.mouseY && app.mouseY < 731)) {
				if (!validPay) {
					addSuero = true;
					addCheese = false;
				}
			}
			// De Extra a Extra+Pay
			if (addChips || addOnionRings && addCheese || addSuero) {
				if ((63 < app.mouseX && app.mouseX < 348) && (787 < app.mouseY && app.mouseY < 845)) {
					validPay = true;
				}
			}

			// De Extra+Pay a Summary
			if ((validPay) && (65 < app.mouseX && app.mouseX < 348) && (736 < app.mouseY && app.mouseY < 789)) {
				validPay = false;
				screen = 5;
				// Se crea orden con Corral
				if (chooseCorral) {
					date = new Date();
					userList.get(0).newOrder("Corral", date, 14000, 0);
				} // Se crea orden con Corral queso
				else if (chooseCheese) {
					date = new Date();
					userList.get(0).newOrder("Corral queso", date, 16000, 0);
				}
				// Se crea orden con Corral tocineta
				else if (chooseBacon) {
					date = new Date();
					userList.get(0).newOrder("Corral tocineta", date, 19000, 0);
				}
				// Se crea orden con Corral pollo
				else if (chooseChicken) {
					date = new Date();
					userList.get(0).newOrder("Corral pollo", date, 15000, 0);
				}
				// Variable para siempre editar la ultima orden
				int lastPos = userList.get(0).getOrderList().size() - 1;

				// extras: papas y queso
				if (addChips && addCheese) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Papas francesas", 5500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("Queso fundido", 4500);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: papas y suero
				else if (addChips && addSuero) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Papas francesas", 5500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("Suero costeño", 3000);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: anillos y queso
				else if (addOnionRings && addCheese) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Anillos de cebolla", 7500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("Queso fundido", 4500);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

				// extras: anillos y suero
				else if (addOnionRings && addSuero) {
					userList.get(0).getOrderList().get(lastPos).addExtra1("Anillos de cebolla", 7500);
					userList.get(0).getOrderList().get(lastPos).addExtra2("Suero costeño", 3000);
					userList.get(0).getOrderList().get(lastPos)
							.setOrderTotal(userList.get(0).getOrderList().get(lastPos).calculateTotal());
				}

			}
			break;
		case 5:
			// De Summary a Home
			if ((63 < app.mouseX && app.mouseX < 348) && (755 < app.mouseY && app.mouseY < 814)) {
				screen = 3;
				addChips = false;
				addOnionRings = false;
				addCheese = false;
				addSuero = false;
				chooseCorral = false;
				chooseCheese = false;
				chooseBacon = false;
				chooseChicken = false;
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
