package com.eldarian.solvdelivery.staff.delivery;

import com.eldarian.solvdelivery.Order;

public class AutoCourier extends Courier {
    String carName;

    public AutoCourier() {
        super();
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivered by " + getName() + " by auto");
    }
}
