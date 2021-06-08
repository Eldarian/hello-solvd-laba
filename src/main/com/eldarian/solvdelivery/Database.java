package com.eldarian.solvdelivery;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.services.CityService;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.PhoneOperator;
import com.eldarian.solvdelivery.staff.contact.WebOperator;
import com.eldarian.solvdelivery.staff.delivery.AutoCourier;
import com.eldarian.solvdelivery.staff.delivery.FootCourier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//temporary class, will be replaced with sql or smth.
public class Database implements CityService {
    List<Restaurant> restaurants;
    Map<String, Street> streets;
    List<Manager> managers;

    public Database() {
        initCity();
        initStaff();
    }

    private void initStaff() {
        managers = new ArrayList<>();
        Manager manager = new Manager();
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

        var perezmen = new Restaurant(kalesnikava, 7, "Perezmen");
        var freedomster = new Restaurant(kalinouski, 3, "Freedomster");
        var meating = new Restaurant(skaryna, 9, "Meating");

        restaurants = new ArrayList<>();
        restaurants.add(perezmen);
        restaurants.add(freedomster);
        restaurants.add(meating);
    }

    @Override
    public Restaurant findRestaurant(String name) {
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getName().equals(name)) return restaurant; //TODO check for errors
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

    public Manager getManager() {
        return managers.get(0); //TODO replace to search of free manager
    }
}
