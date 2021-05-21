package com.eldarian.solvdelivery.stuff.operators;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.Manager;

public class PhoneOperator extends Operator {

    public PhoneOperator(Manager manager) {
        super(manager);
    }


    @Override
    public void setAddress(String address) {

    }

    @Override
    public void setRestaurant(int id) {

    }

    @Override
    public String getRestaurants() {
        return null;
    }

    @Override
    public void setDish(int id) {

    }

    @Override
    public boolean confirmOrder(boolean isClientAgreed) {
        return false;
    }

    public boolean handleOrder(Order order) {
        return true; //TODO add logic
    }
}

