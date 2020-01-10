package org.softwire.training.garage.models.vehicles;

import org.softwire.training.garage.models.garage.SpaceType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Vehicle {
    private final LocalDateTime timeOfEntry;
    private final String registrationNumber;
    private final boolean isLong;
    private final boolean isTall;

    public Vehicle(String registrationNumber, boolean isLong, boolean isTall) {
        timeOfEntry = LocalDateTime.now();
        this.registrationNumber = registrationNumber;
        this.isLong = isLong;
        this.isTall = isTall;
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isLong() {
        return isLong;
    }

    public boolean isTall() {
        return isTall;
    }

    public List<SpaceType> getCompatibleSpaceTypes (){
        List<SpaceType> spaceTypes = new ArrayList<>(Collections.singletonList(SpaceType.STANDARD));
        if (isLong()){
            return Collections.singletonList(SpaceType.LONG);
        }

        if (!isTall()) {
            spaceTypes.add(SpaceType.LOW);
        }
        return spaceTypes;
    }
}
