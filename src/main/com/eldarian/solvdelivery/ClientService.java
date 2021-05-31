package com.eldarian.solvdelivery;

public interface ClientService {
    void handleAddress(String address);

    void handleRestaurant(int id);

    void handleDish(int id);

    boolean confirmOrder(boolean isClientAgreed);
}
