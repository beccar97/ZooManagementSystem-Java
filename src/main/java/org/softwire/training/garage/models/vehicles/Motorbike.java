package org.softwire.training.garage.models.vehicles;

import org.softwire.training.garage.models.garage.SpaceType;

import java.util.List;

public class Motorbike extends Vehicle {
    public Motorbike(String registrationNumber) {
        super(registrationNumber, false, false);
    }

    @Override
    public List<SpaceType> getCompatibleSpaceTypes() {
        List<SpaceType> spaceTypes = super.getCompatibleSpaceTypes();
        spaceTypes.add(SpaceType.MOTORBIKE);
        return spaceTypes;
    }
}
