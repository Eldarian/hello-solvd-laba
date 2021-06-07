package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.delivery.AutoCourier;
import com.eldarian.solvdelivery.staff.delivery.FootCourier;
import com.eldarian.solvdelivery.staff.contact.PhoneOperator;
import com.eldarian.solvdelivery.staff.contact.WebOperator;

public class Executor {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.addCourier(new FootCourier());
		manager.addCourier(new AutoCourier());
		manager.addOperator(new PhoneOperator(manager));
		manager.addOperator(new WebOperator(manager));
		Client client = new Client(manager);
		client.makeOrder();
	}

}
