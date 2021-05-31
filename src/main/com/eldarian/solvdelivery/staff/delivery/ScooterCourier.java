package com.eldarian.solvdelivery.staff.delivery;

import com.eldarian.solvdelivery.Order;

public class ScooterCourier extends AutoCourier {

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivered by " + getName() + " by scooter");
    }
}
