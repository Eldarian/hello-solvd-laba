package com.eldarian.solvdelivery.stuff;

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
    public void getRequest(int requestId) {
        System.out.printf("Got request with id %d", requestId);
    }
}