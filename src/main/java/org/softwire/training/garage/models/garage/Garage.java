package org.softwire.training.garage.models.garage;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    List<Floor> floors;

    public Garage(List<FloorPlan> plan) {
        this.floors = new ArrayList<>();
        plan.forEach(this::addFloor);
    }

    public List<Floor> getAllFloors() {
        return floors;
    }

    public Floor getFloor(int n) {
        return floors.stream().filter(floor -> floor.getNumber() == n)
                .findFirst().orElse(null);
    }

    private void addFloor(FloorPlan floorPlan) {
        floors.add(new Floor(nextFloorNumber(), floorPlan));
    }

    private int nextFloorNumber() {
        return floors.size() + 1;
    }
}
