package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.Manager;

public class PhoneOperator extends Operator {

    public PhoneOperator(Manager manager) {
        super(manager);
    }


    @Override
    public void handleAddress(String address) {

    }

    @Override
    public void handleRestaurant(String restaurant) {
        if(restaurant.matches("\\d+")) {
            findRestaurant(Integer.parseInt(restaurant));
        } else {
            findRestaurant(restaurant);
        }
    }

    @Override
    public void handleDish(int id) {

    }

    @Override
    public boolean confirmOrder(boolean isClientAgreed) {
        return false;
    }

    public boolean handleOrder(Order order) {
        return true; //TODO add logic
    }

    @Override
    public void handleClientData(String data) {
        //TODO register clients phone number
    }
}

