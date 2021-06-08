package com.eldarian.solvdelivery.services;

import com.eldarian.solvdelivery.Dish;

public interface RestaurantService {
    Dish findDish(String name);
}
