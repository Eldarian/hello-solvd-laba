package com.eldarian.solvdelivery;

public interface ClientService {

    void handleAddress(String address);

    void handleRestaurant(String name);

    void handleDish(int id);

    boolean confirmOrder(String isClientAgreed);
}
