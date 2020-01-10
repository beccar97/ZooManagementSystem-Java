package org.softwire.training.garage.models.garage;

import org.softwire.training.garage.models.vehicles.Vehicle;

public class Space {
    private final SpaceType type;
    private Vehicle occupant;
    private final int number;

    //Constructors
    public Space(SpaceType type, int number) {
        this.type = type;
        this.number = number;
    }

    //Getters
    public SpaceType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public Vehicle getOccupant() {
        return occupant;
    }

    //Setters
    private void setOccupant(Vehicle occupant) {
        this.occupant = occupant;
    }

    //Methods
    public void park(Vehicle vehicle) {
        setOccupant(vehicle);
    }

    public Vehicle vacate() {
        Vehicle exitingVehicle = this.occupant;
        setOccupant(null);
        return exitingVehicle;
    }

    public boolean isOccupied() {
        return this.occupant != null;
    }

    public boolean isAvailable() {
        return this.occupant == null;
    }
}
