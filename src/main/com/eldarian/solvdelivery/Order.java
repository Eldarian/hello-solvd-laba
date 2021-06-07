package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.city.Restaurant;

public class Order {
	int id;

	private Restaurant restaurant;
	private Dish dish;

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", restaurant=" + restaurant +
				", dish=" + dish +
				'}';
	}
}
