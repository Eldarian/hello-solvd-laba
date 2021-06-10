package com.eldarian.solvdelivery.city;

import java.util.ArrayList;
import java.util.List;

public class Street {
    List<Building> buildings;
    private String name;

    public Street(String name, int buildingCount) {
        this.name = name;
        buildings = new ArrayList<>();
        for (int i = 1; i <= buildingCount; i++) {
            buildings.add(new Building(this, i));
        }
    }

    public String getName() {
        return name;
    }

    public int getBuildingCount() {
        return buildings.size();
    }

    public Building getBuilding(int buildingNumber) {
        if(buildingNumber <= buildings.size() && buildingNumber > 0) {
            return buildings.get(buildingNumber - 1);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Street{" +
                "buildingsCount=" + buildings.size() +
                ", name='" + name + '\'' +
                '}';
    }
}
