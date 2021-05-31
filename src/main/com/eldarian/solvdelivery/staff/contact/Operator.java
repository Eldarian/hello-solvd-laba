package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.ClientService;
import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.Employee;
import com.eldarian.solvdelivery.staff.Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator extends Employee implements ClientService {
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

    @Override
    public boolean handleOrder(Order order) {
        if(isFree) {
            this.order = order;
            return true;
        }
        return false;
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

    public abstract void handleClientData(String data);
}
