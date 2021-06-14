package com.eldarian.solvdelivery.ordering;

import com.eldarian.solvdelivery.data.OrderController;
import com.eldarian.solvdelivery.staff.Manager;
import com.eldarian.solvdelivery.staff.contact.Operator;

public class Client {

    public void sendOrder() {
        Manager manager = OrderController.getInstance().getManager();
        Operator operator = manager.contactOperator();
        if(operator == null) return;
        Order order = operator.generateOrder();
        operator.confirmOrder(order);
    }
}
