package org.softwire.training.garage.models.garage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Floor {
    private List<Space> spaces;
    private final int number;

    // Construction
    public Floor(int floorNumber, FloorPlan floorPlan) {
        this.number = floorNumber;
        this.spaces = new ArrayList<>();
        addSpaces(SpaceType.STANDARD, floorPlan.getStandardSpaces());
        addSpaces(SpaceType.MOTORBIKE, floorPlan.getMotorbikeSpaces());
        addSpaces(SpaceType.LONG, floorPlan.getLongSpaces());
        addSpaces(SpaceType.LOW, floorPlan.getLowSpaces());
    }

    private void addSpace(SpaceType type) {
        spaces.add(new Space(type, this.spaces.size() + 1));
    }

    private void addSpaces(SpaceType type, int number) {
        for (int i = 0; i < number; i++) addSpace(type);
    }

    // Methods
    public int getNumber() {
        return number;
    }

    public List<Space> getAllSpaces() {
        return spaces;
    }

    public List<Space> getAvailableSpaces() {
        return spaces.stream().filter(Space::isAvailable).collect(Collectors.toList());
    }

    public long getNumberAvailableSpaces() {
        return spaces.stream().filter(Space::isAvailable).count();
    }

    public List<Space> getAllSpacesOfType(SpaceType type) {
        return spaces.stream().filter(space -> space.getType() == type).collect(Collectors.toList());
    }

    public List<Space> getAvailableSpacesOfType(SpaceType type) {
        return spaces.stream().filter(space -> space.isAvailable()
                && space.getType() == type).collect(Collectors.toList());
    }

    public long getNumberAvailableSpacesOfType(SpaceType type) {
        return spaces.stream().filter(space -> space.isAvailable()
                && space.getType() == type).count();
    }

}
