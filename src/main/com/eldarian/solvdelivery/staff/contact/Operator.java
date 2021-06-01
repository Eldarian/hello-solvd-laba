package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.ClientService;
import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.Restaurant;
import com.eldarian.solvdelivery.staff.Employee;
import com.eldarian.solvdelivery.staff.Manager;

import java.util.LinkedList;
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
        List<Operator> operators = new LinkedList<Operator>();
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
    public void handleRestaurant(String restaurant) {

    }

    protected Restaurant findRestaurant(int id) {
        //TODO find restaurant in list by id
        return new Restaurant(id);
    }

    protected Restaurant findRestaurant(String name) {
        //TODO find restaurant in list by name
        return new Restaurant(name);
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
