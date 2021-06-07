package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.ClientService;
import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.staff.Employee;
import com.eldarian.solvdelivery.staff.Manager;

import java.util.LinkedList;
import java.util.List;

public abstract class Operator extends Employee implements ClientService {
    private Manager manager;    //PENDING private with getters for child classes or protected

    public Manager getManager() {
        return manager;
    }

    public boolean isFree() {
        return isFree;
    }

    public Order getOrder() {
        return order;
    }

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


    @Override
    public String toString() { //PENDING Does this make any sense?
        return "Operator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + manager +
                ", isFree=" + isFree +
                ", order=" + order +
                '}';
    }

    @Override
    public void handleDish(int id) {

    }

    @Override
    public boolean confirmOrder(String isClientAgreed) {
        return false;
    }

    public abstract void handleClientData(String data);

    public Restaurant findRestaurant(String name) {
        return null; //TODO find restaurant by name and return it
    }
}

