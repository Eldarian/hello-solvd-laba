package com.eldarian.solvdelivery;

public interface ClientService {
    void setAddress(String address);

    void setRestaurant(int id);

    String getRestaurants();

    void setDish(int id);

    boolean confirmOrder(boolean isClientAgreed);
}
