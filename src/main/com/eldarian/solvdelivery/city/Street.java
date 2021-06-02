package com.eldarian.solvdelivery.city;

import java.util.ArrayList;
import java.util.List;

public class Street {
    List<Building> buildings;

    public Street(int buildingCount) {
        buildings = new ArrayList<>();
        for (int i = 0; i < buildingCount; i++) {
            buildings.add(new Building());
        }
    }

}
