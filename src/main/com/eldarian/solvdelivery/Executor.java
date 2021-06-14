package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.data.Database;
import com.eldarian.solvdelivery.ordering.Client;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

import java.util.ArrayList;
import java.util.List;

public class Executor {

	public static void main(String[] args) {
		Client client = new Client();

		client.sendOrder();
	}

}
