package org.softwire.training.garage.models.garage;

import org.softwire.training.garage.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Space> findSpaceFor(Vehicle vehicle) {
        List<Space> possibleSpaces = floors.stream()
                .flatMap(floor -> floor.findSpacesFor(vehicle).stream())
                .collect(Collectors.toList());

        return possibleSpaces.stream().min((space1, space2) -> compareSpaces(space1, space2, vehicle));
    }

    private int compareSpaces(Space space1, Space space2, Vehicle vehicle) {
        // TODO make depend on vehicle type

        if (space1.getType() == SpaceType.MOTORBIKE) return -1;
        else if (space2.getType() == SpaceType.MOTORBIKE) return 1;

        if (space1.getType() == SpaceType.LONG) return -1;
        else if (space2.getType() == SpaceType.LONG) return 1;

        if (space1.getType() == SpaceType.LOW) return -1;
        else if (space2.getType() == SpaceType.LOW) return 1;

        return 0;
    }
}
