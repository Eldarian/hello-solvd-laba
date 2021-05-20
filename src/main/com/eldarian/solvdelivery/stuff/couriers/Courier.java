package com.eldarian.solvdelivery.stuff.couriers;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.Employee;

public abstract class Courier extends Employee {

	Order order;
	
	public Courier() {
		super();
	}

	@Override
	public void getRequest(int requestId) {
		System.out.printf("Got request number %d", requestId);
	}

}
