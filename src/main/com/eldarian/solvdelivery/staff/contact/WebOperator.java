package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.Manager;

public class WebOperator extends Operator{

    public WebOperator(Manager manager) {
        super();
    }

    public boolean handleOrder(Order order) {
        return true; //TODO add logic
    }

    @Override
    public void handleClientData(String data) {
        //TODO register user
    }

    public String toString() {
        return "WebOperator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + getManager() +
                ", isFree=" + isFree() +
                ", order=" + getOrder() +
                '}';
    }
}
