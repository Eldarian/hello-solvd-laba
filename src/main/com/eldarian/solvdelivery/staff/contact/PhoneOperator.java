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
    public void handleRestaurant(int id) {

    }

    public String getRestaurants() {
        return null;
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

