package com.eldarian.solvdelivery.data;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.ordering.Dish;
import com.eldarian.solvdelivery.services.CityService;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.PhoneOperator;
import com.eldarian.solvdelivery.staff.contact.WebOperator;
import com.eldarian.solvdelivery.staff.delivery.AutoCourier;
import com.eldarian.solvdelivery.staff.delivery.FootCourier;

import java.util.*;

//temporary class, will be replaced with sql or smth.
public class Database implements CityService {
    List<Restaurant> restaurants;
    Map<String, Street> streets;
    List<Manager> managers;

    public Database() {
        initCity();
        initStaff();
    }

    //hardcoded method with data
    private void initStaff() {
        managers = new ArrayList<>();
        Manager manager = new Manager(this);
        manager.addCourier(new FootCourier());
        manager.addCourier(new AutoCourier());
        manager.addOperator(new PhoneOperator(manager));
        manager.addOperator(new WebOperator(manager));
        managers.add(manager);
    }

    //hardcoded method with data
    private void initCity() {
        streets = new HashMap();
        var kalesnikava = new Street("Kalesnikava Street", 12);
        var kalinouski = new Street("Kalinouski Alley", 8);
        var skaryna = new Street("Skaryna Prospect", 15);
        streets.put("Kalesnikava Street", kalesnikava);
        streets.put("Kalinouski Alley", kalinouski);
        streets.put("Skaryna Prospect", skaryna);

        List<Dish> perezmenMenu = new ArrayList<>();
        perezmenMenu.add(new Dish("pizza"));
        perezmenMenu.add(new Dish("burger"));
        perezmenMenu.add(new Dish("cola"));

        List<Dish> freedomsterMenu = new ArrayList<>();
        freedomsterMenu.add(new Dish("domster"));
        freedomsterMenu.add(new Dish("shawarma"));

        List<Dish> meatingMenu = new ArrayList<>();
        meatingMenu.add(new Dish("chicken barbeque"));
        meatingMenu.add(new Dish("meatballs"));
        meatingMenu.add(new Dish("pork kebab"));

        var perezmen = new Restaurant(kalesnikava, 7, "Perezmen", perezmenMenu);
        var freedomster = new Restaurant(kalinouski, 3, "Freedomster", freedomsterMenu);
        var meating = new Restaurant(skaryna, 9, "Meating", meatingMenu);

        restaurants = new ArrayList<>();
        restaurants.add(perezmen);
        restaurants.add(freedomster);
        restaurants.add(meating);
    }

    @Override
    public Restaurant findRestaurant(String name) {
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getName().equals(name)) return restaurant;
        }
        return null;
    }

    @Override
    public Building findBuilding(Street street, int buildingNumber) {
        return street.getBuilding(buildingNumber);
    }

    @Override
    public Street findStreet(String name) {
        return streets.get(name);
    }

    @Override
    public Restaurant findRestaurant(int id) {
        return restaurants.get(id);
    }

    public Manager getManager() {
        return managers.get(0); //TODO replace to search of free manager or make single-manager system
    }

    @Override
    public List<String> getRestaurantNames() {
        List<String> list = new ArrayList<>();
        for (Restaurant restaurant: restaurants) {
            list.add(restaurants.indexOf(restaurant) + ": " + restaurant.getName());
        }
        return list;
    }

    @Override
    public List<String> getStreetNames() {
        List<String> list = new ArrayList<>();
        for (String street: streets.keySet()) {
            list.add(street + ", " + streets.get(street).getBuildingCount() + " buildings");
        }
        return list;
    }
}
