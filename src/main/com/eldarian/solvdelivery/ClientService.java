package com.eldarian.solvdelivery;

public interface ClientService {
    int maxQueue = 99;
    void handleAddress(String address);

    void handleRestaurant(String restaurant);

    void handleDish(int id);

    boolean confirmOrder(String isClientAgreed);
}
