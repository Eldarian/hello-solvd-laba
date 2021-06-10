package com.eldarian.solvdelivery.services;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;

import java.util.List;

public interface CityService {
    Restaurant findRestaurant(String name);
    Building findBuilding(Street street, int buildingNumber);
    Street findStreet(String name);
    Restaurant findRestaurant(int id);

    List<String> getRestaurantNames();
    List<String> getStreetNames();



}
