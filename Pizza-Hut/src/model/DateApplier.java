package model;

import java.util.Comparator;

public class DateApplier implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		// TODO Auto-generated method stub

		return o1.getOrderDate().compareTo(o2.getOrderDate());
	}
}
