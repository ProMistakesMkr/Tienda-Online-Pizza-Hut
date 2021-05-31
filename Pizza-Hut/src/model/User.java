package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private String name;
	private String email;
	private String password;
	
	private ArrayList<Order> orderList;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
		
		orderList = new ArrayList<Order>();
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void newOrder(String dn, Date od, int dp, int ot) {
		orderList.add(new Order(dn, od, dp, ot));
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
}
