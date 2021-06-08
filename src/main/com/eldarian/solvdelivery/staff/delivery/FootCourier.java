package com.eldarian.solvdelivery.staff.delivery;

import com.eldarian.solvdelivery.Order;

public class FootCourier extends Courier {

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivered by " + getName() + " by foot");
    }

    @Override
    public String toString() {
        return super.toString() + ", foot";
    }
}
