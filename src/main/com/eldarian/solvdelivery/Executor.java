package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.data.Database;
import com.eldarian.solvdelivery.ordering.Client;
import com.eldarian.solvdelivery.staff.Manager;

public class Executor {

	public static void main(String[] args) {
		Database db = new Database();
		Manager manager = db.getManager();
		Client client = new Client(manager);

		client.sendOrder();
	}

}
