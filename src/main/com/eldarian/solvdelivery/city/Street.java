package com.eldarian.solvdelivery.city;

import java.util.ArrayList;
import java.util.List;

public class Street {
    List<Building> buildings;
    private String name;

    public Street(String name, int buildingCount) {
        this.name = name;
        buildings = new ArrayList<>();
        for (int i = 0; i < buildingCount; i++) {
            buildings.add(new Building(this, i));
        }
    }

    public String getName() {
        return name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Building getBuilding(int buildingNumber) {
        if(buildingNumber - 1 > buildings.size()) {
            return buildings.get(buildingNumber - 1);
        }
        return null;
    }

    public void setBuilding(Building building, int number) {
        buildings.set(number - 1, building);
    }

    @Override
    public String toString() {
        return "Street{" +
                "buildingsCount=" + buildings.size() +
                ", name='" + name + '\'' +
                '}';
    }
}
