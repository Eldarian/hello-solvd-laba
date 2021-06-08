package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.staff.Manager;

public class Executor {

	public static void main(String[] args) {
		Database db = new Database();

		Manager manager = db.getManager();

		Client client = new Client(manager);
		client.sendOrder();
	}

}
