package com.eldarian.solvdelivery.stuff;

import com.eldarian.solvdelivery.stuff.couriers.Courier;
import com.eldarian.solvdelivery.stuff.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Courier> couriers;
    private List<Operator> operators;

    public Manager() {
        this.couriers = new ArrayList<>();
        this.operators = new ArrayList<>();
    }

    public Manager(List couriers, List operators) {
        this();
        this.couriers = couriers;
        this.operators = operators;
    }

    @Override
    public void getRequest(String message) {
        System.out.printf("Got request with id %d", requestId);
    }

    @Override
    public void sendRequest(String message) {

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