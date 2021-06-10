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


		//Test street readability
		Street street = db.findStreet("Kalesnikava Street");
		System.out.println(street);
		for (int i = 1; i <= street.getBuildingCount(); i++) {
			System.out.println(db.findBuilding(street, i));
		}
		//end test

		client.sendOrder();
	}

}
