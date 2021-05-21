package com.eldarian.solvdelivery.stuff.operators;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.Manager;

public class WebOperator extends Operator{

    public WebOperator(Manager manager) {
        super();
    }

    public boolean handleOrder(Order order) {
        return true; //TODO add logic
    }

}
