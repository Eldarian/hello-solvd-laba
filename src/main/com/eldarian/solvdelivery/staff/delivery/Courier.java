package com.eldarian.solvdelivery.staff.delivery;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.Employee;

public abstract class Courier extends Employee {

	Order order;
	boolean isFree = true;
	public Courier() {
		super();
	}


	@Override
	public boolean handleOrder(Order order) {
		if(isFree) {
			this.order = order;
			isFree = false;
			deliverOrder(order);
			return true;
		}
		return false;
	}

	public abstract void deliverOrder(Order order);

	@Override
	public String toString() {
		return "Courier{" +
				"order=" + order +
				", isFree=" + isFree +
				'}';
	}
}
