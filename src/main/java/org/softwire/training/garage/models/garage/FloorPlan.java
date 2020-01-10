package org.softwire.training.garage.models.garage;

public class FloorPlan {
    private int standardSpaces;
    private int motorbikeSpaces;
    private int longSpaces;
    private int lowSpaces;

    public FloorPlan(int standardSpaces, int motorbikeSpaces, int longSpaces, int lowSpaces) {
        this.standardSpaces = standardSpaces;
        this.motorbikeSpaces = motorbikeSpaces;
        this.longSpaces = longSpaces;
        this.lowSpaces = lowSpaces;
    }

    public int getStandardSpaces() {
        return standardSpaces;
    }

    public int getMotorbikeSpaces() {
        return motorbikeSpaces;
    }

    public int getLongSpaces() {
        return longSpaces;
    }

    public int getLowSpaces() {
        return lowSpaces;
    }
}
