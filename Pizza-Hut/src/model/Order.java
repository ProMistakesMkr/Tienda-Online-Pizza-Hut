package model;

import java.util.Date;

public class Order implements Comparable<Order>{
	private String dishName;
	private Date orderDate;
	private int dishPrice;
	private int orderTotal;
	
	private Extra[] extraList;
	
	public Order(String dishName, Date orderDate, int dishPrice, int orderTotal) {
		this.dishName = dishName;
		this.orderDate = orderDate;
		this.dishPrice = dishPrice;
		this.orderTotal = orderTotal;
		extraList = new Extra[2];
	}

	public String getDishName() {
		return dishName;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public int getDishPrice() {
		return dishPrice;
	}
	
	public Extra getExtra(int x) {
		return extraList[x];
	}
	
	public void addExtra1 (String en, int ep) {
		extraList[0] = new Extra(en, ep);
	}
	
	public void addExtra2 (String en, int ep) {
		extraList[1] = new Extra(en, ep);
	}
		
	public int calculateTotal() {
		return extraList[0].getExtraPrice() + extraList[1].getExtraPrice() + dishPrice;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public int compareTo(Order nextOrder) {
		// TODO Auto-generated method stub
		return this.orderTotal - nextOrder.getOrderTotal();
	}
	
}
