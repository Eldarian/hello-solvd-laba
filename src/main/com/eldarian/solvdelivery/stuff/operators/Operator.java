package com.eldarian.solvdelivery.stuff;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator extends Employee {
    protected Manager manager;

    public Operator(Manager manager) {
        this.manager = manager;
    }

    public Operator() {
        List<Operator> operators = new ArrayList<Operator>();
        operators.add(this);
        this.manager = new Manager(null, operators);
    }
}
