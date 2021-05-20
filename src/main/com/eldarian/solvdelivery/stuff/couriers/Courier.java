package com.eldarian.solvdelivery.stuff;

import com.eldarian.solvdelivery.Order;

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
