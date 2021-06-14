package com.eldarian.solvdelivery.data;

import com.eldarian.solvdelivery.staff.Manager;

public class OrderController {
    private static OrderController orderController;
    private Database db;

    private OrderController() {

    }

    public static OrderController getInstance() {
        if(orderController == null) {
            orderController = new OrderController();
        }
        return orderController;
    }

    public Manager getManager() {
        if(db == null) {
            db = new Database();
        }
        return db.getManager();
    }
}
