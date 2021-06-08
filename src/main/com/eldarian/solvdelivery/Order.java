package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;

public class Order {
	int id;

	private Restaurant restaurant;
	private Dish dish;
	private Building destination;

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", restaurant=" + restaurant +
				", dish=" + dish +
				'}';
	}

    public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
    }

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public void setDestination(Building destination) {
		this.destination = destination;
	}
}
