package com.eldarian.solvdelivery.city;

import com.eldarian.solvdelivery.ordering.Dish;
import com.eldarian.solvdelivery.services.RestaurantService;

import java.util.List;

public class Restaurant extends Building implements RestaurantService {
    private String name;
    private List<Dish> menu;

    public Restaurant(Street street, int buildingNumber, String name, List<Dish> menu) {
        super(street, buildingNumber);
        this.name = name;
        this.menu = menu;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void printMenu() {
        for (Dish dish : menu) {
            System.out.println(dish.getName());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " on " + getStreet().getName() +
                ", " + getBuildingNumber();
    }

    @Override
    public Dish findDish(String name) {
        for (Dish dish: menu) {
            if(dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }
}
