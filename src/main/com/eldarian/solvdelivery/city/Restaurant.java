package com.eldarian.solvdelivery.city;

public class Restaurant extends Building {
    private int id;
    private String name;

    public Restaurant(Street street, int buildingNumber, String name) {
        super(street, buildingNumber);
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "streetName=" + getStreet().getName() +
                ", buildingNumber=" + getBuildingNumber() +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
