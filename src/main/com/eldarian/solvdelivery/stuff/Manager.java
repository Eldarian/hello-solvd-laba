package com.eldarian.solvdelivery.stuff;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.couriers.Courier;
import com.eldarian.solvdelivery.stuff.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Courier> couriers;
    private List<Operator> operators;
    private boolean isFree = true;
    private Order currentOrder;

    public Manager() {
        this.couriers = new ArrayList<>();
        this.operators = new ArrayList<>();
    }

    public Manager(List couriers, List operators) {
        this.couriers = couriers;
        this.operators = operators;
    }


    @Override
    public boolean handleOrder(Order order) {
        if(isFree) {
            currentOrder = order;
            isFree = false;
            return true;
        }
        return false;
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }
}