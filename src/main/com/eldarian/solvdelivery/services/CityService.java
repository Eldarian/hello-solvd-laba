package com.eldarian.solvdelivery.services;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;

public interface CityService {
    Restaurant findRestaurant(String name);
    Building findBuilding(Street street, int buildingNumber);
    Street findStreet(String name);

}
