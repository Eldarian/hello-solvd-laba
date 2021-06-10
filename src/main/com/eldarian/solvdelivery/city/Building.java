package com.eldarian.solvdelivery.city;

public class Building {
    private Street street;
    private int buildingNumber;

    private Building() {

    }

    public Building(Street street, int buildingNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        System.out.println("Init building on " + street + ", " + buildingNumber);
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public Street getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Building{" +
                "street=" + street.getName() +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
