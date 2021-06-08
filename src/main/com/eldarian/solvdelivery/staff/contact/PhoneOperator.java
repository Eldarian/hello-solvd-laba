package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.Manager;

public class PhoneOperator extends Operator {

    public PhoneOperator(Manager manager) {
        super(manager);
    }

    public boolean handleOrder(Order order) {
        return true; //TODO add logic
    }

    @Override
    public void handleClientData(String data) {
        //TODO register clients phone number
    }

    @Override
    public String toString() {
        return "PhoneOperator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + getManager() +
                ", order=" + getOrder() +
                '}';
    }
}

