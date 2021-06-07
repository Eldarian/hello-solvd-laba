package com.eldarian.solvdelivery.staff;

import com.eldarian.solvdelivery.Order;
import com.eldarian.solvdelivery.staff.delivery.Courier;
import com.eldarian.solvdelivery.staff.contact.Operator;
import com.eldarian.solvdelivery.staff.contact.PhoneOperator;
import com.eldarian.solvdelivery.staff.contact.WebOperator;

import java.util.LinkedList;
import java.util.List;

public class Manager extends Employee {
    private List<Courier> couriers;
    private List<Operator> operators;
    private boolean isFree = true;
    private Order currentOrder;

    public Manager() {
        this.couriers = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public Manager(List couriers, List operators) {
        this.couriers = couriers;
        this.operators = operators;
    }


    @Override
    public boolean handleOrder(Order order) {
        if(isFree) {
            currentOrder = order;
            isFree = false;
            return true;
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

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}