package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.stuff.Manager;
import com.eldarian.solvdelivery.stuff.couriers.AutoCourier;
import com.eldarian.solvdelivery.stuff.couriers.FootCourier;
import com.eldarian.solvdelivery.stuff.operators.PhoneOperator;
import com.eldarian.solvdelivery.stuff.operators.WebOperator;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.addCourier(new FootCourier());
		manager.addCourier(new AutoCourier());
		manager.addOperator(new PhoneOperator(manager));
		manager.addOperator(new WebOperator(manager));
		
	}

}
