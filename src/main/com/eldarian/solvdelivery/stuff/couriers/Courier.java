package com.eldarian.solvdelivery.stuff.couriers;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.Employee;

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
			return true;
		}
		return false;
	}
}
