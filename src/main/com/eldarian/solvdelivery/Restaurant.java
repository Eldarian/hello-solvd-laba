package com.eldarian.solvdelivery;

public class Restaurant {
    int id;
    String name;

    public Restaurant(int id) {
        this.id = id; //non-sense, TODO remove
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant() {

    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
