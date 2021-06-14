package com.eldarian.solvdelivery.ordering;

import com.eldarian.solvdelivery.data.Database;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

public class Client {

    public void makeOrder() {
        Manager manager = Database.getInstance().getManager();
        Operator operator = manager.contactOperator();
        if(operator == null) return;
        Order order = operator.generateOrder();
        operator.confirmOrder(order);
    }
}
