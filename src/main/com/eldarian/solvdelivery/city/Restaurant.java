package com.eldarian.solvdelivery.city;

import com.eldarian.solvdelivery.Dish;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Building {
    private String name;
    private List<Dish> menu;

    public Restaurant(Street street, int buildingNumber, String name) {
        super(street, buildingNumber);
        this.name = name;
        menu = new ArrayList<>();
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "streetName=" + getStreet().getName() +
                ", buildingNumber=" + getBuildingNumber() +
                ", name='" + name + '\'' +
                '}';
    }
}
