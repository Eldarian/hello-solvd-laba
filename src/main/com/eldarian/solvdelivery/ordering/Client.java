package com.eldarian.solvdelivery.ordering;

import com.eldarian.solvdelivery.city.Building;
import com.eldarian.solvdelivery.city.Restaurant;
import com.eldarian.solvdelivery.city.Street;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

import java.util.Scanner;

public class Client {

    public void sendOrder(Manager manager) {
        Operator operator = manager.contactOperator();
        if(operator == null) return;
        Order order = operator.generateOrder();
        operator.confirmOrder(order);
    }






}
