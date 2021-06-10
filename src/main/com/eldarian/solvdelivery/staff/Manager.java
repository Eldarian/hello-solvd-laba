package com.eldarian.solvdelivery.staff;

import com.eldarian.solvdelivery.ordering.Order;
import com.eldarian.solvdelivery.services.CityService;
import com.eldarian.solvdelivery.staff.delivery.Courier;
import com.eldarian.solvdelivery.staff.contact.Operator;
import com.eldarian.solvdelivery.staff.contact.PhoneOperator;
import com.eldarian.solvdelivery.staff.contact.WebOperator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Employee {
    private List<Courier> couriers;
    private List<Operator> operators;
    CityService cityService;

    public Manager() {
        this.couriers = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public Manager(CityService cityService) {
        this.couriers = new LinkedList<>();
        this.operators = new LinkedList<>();
        this.cityService = cityService;
    }

    public Manager(List couriers, List operators) {
        this.couriers = couriers;
        this.operators = operators;
    }


    @Override
    public boolean handleOrder(Order order) {
        for(Courier courier : couriers) {
            if(courier.isFree()) {
                courier.handleOrder(order);
                return true;
            }
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

    public Operator getWebOperator() {
        return new WebOperator(this); //TODO find WebOperator in list
    }

    public Operator getPhoneOperator() {
        return new PhoneOperator(this); //TODO find PhoneOperator in list
    }

    public CityService getCityService() {
        return cityService;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

    public Operator contactOperator() {
        System.out.println("Welcome to DelivereD! [p]hone or [w]eb?");
        Scanner scanner = new Scanner(System.in);
        Operator operator = null;
        int attempt = 0;

        do {
            String line = scanner.nextLine();
            switch (line) {
                case "phone":
                case "p":
                    operator = getPhoneOperator();
                    if(operator == null) {
                        System.out.println("There is no available phone operator or there is error");
                        break;
                    }
                    System.out.println("Called Phone Operator " + operator.getName());
                    break;
                case "web":
                case "w":
                    operator = getWebOperator();
                    if(operator == null) {
                        System.out.println("There is no available phone operator or there is error");
                        break;
                    }
                    System.out.println("Called Web Operator " + operator.getName());
                    break;
                default:
                    System.out.println("Incorrect type, try again. [p]hone or [w]eb?");
                    break;
            }
            attempt++;
        } while (operator == null && attempt < 10);
        if(attempt >= 10) {
            System.out.println("Error: too many attempts");
        }
        return operator;
    }
}