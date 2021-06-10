package com.eldarian.solvdelivery.staff.contact;

import com.eldarian.solvdelivery.ordering.Order;
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
    private Order order;

    public Operator(Manager manager) {
        super();
        this.manager = manager;
        manager.addOperator(this);
        cityService = manager.getCityService();
    }

    public Operator() {  //TODO remove
        List<Operator> operators = new LinkedList<Operator>();
        operators.add(this);
        this.manager = new Manager(null, operators);
    }

    public abstract void handleClientData(String data);

    @Override
    public boolean handleOrder(Order order) {
        if(order.isValid()) {
            return manager.handleOrder(order);
        }
        return false;
    }


    @Override
    public String toString() {
        return "Operator{" + "id=" + getId() +
                ", name='" + getName() +
                "manager=" + manager +
                ", order=" + order +
                '}';
    }

    public Restaurant findRestaurant(String name) {
        return cityService.findRestaurant(name);
    }

    public Building findBuilding(Street street, int number) {
        return cityService.findBuilding(street, number);
    }

    public Street findStreet(String name) {
        return cityService.findStreet(name);
    }

    public Manager getManager() {
        return manager;
    }

    public Order getOrder() {
        return order;
    }

    public void printRestaurants() {
        for (String restaurantName : cityService.getRestaurantNames()) {
            System.out.println(restaurantName);
        }
    }

    public void printStreetNames() {
        for (String streetName : cityService.getStreetNames()) {
            System.out.println(streetName);
        }
    }
}

