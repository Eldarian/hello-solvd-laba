package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.services.CityService;
import com.eldarian.solvdelivery.staff.Employee;
import com.eldarian.solvdelivery.staff.Manager;

import java.util.LinkedList;
import java.util.List;

public abstract class Operator extends Employee {
    private Manager manager;    //QUESTION private with getters for child classes or protected

    private CityService cityService;

    public Manager getManager() {
        return manager;
    }

    public Order getOrder() {
        return order;
    }

    private Order order;

    public Operator(Manager manager) {
        super();
        this.manager = manager;
        manager.addOperator(this);
    }

    public Operator() {
        List<Operator> operators = new LinkedList<Operator>();
        operators.add(this);
        this.manager = new Manager(null, operators);
    }

    @Override
    public boolean handleOrder(Order order) {
        return manager.handleOrder(order);
    }


    @Override
    public String toString() { //QUESTION Does this make any sense for abstract class?
        return "Operator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + manager +
                ", order=" + order +
                '}';
    }

    public abstract void handleClientData(String data);

    public Restaurant findRestaurant(String name) {
        return cityService.findRestaurant(name);
    }

    public Building findBuilding(Street street, int number) {
        return cityService.findBuilding(street, number);
    }

    public Street findStreet(String name) {
        return cityService.findStreet(name);
    }
}

