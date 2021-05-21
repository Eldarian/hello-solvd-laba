package com.eldarian.solvdelivery.stuff.operators;

import com.eldarian.solvdelivery.IClientService;
import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.stuff.Employee;
import com.eldarian.solvdelivery.stuff.Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator extends Employee {
    protected Manager manager;
    private boolean isFree;
    private Order order;

    public Operator(Manager manager) {
        super();
        this.manager = manager;
    }

    public Operator() {
        List<Operator> operators = new ArrayList<Operator>();
        operators.add(this);
        this.manager = new Manager(null, operators);
    }
}
