package org.softwire.training.garage.service;

import org.softwire.training.garage.models.garage.Garage;
import org.softwire.training.garage.models.garage.Space;
import org.softwire.training.garage.models.vehicles.Vehicle;

import java.util.Optional;

public class Valet {
    private static Valet instance;

    private Valet() {

    }

    public static Valet getInstance() {
        if (instance == null) {
            instance = new Valet();
        }

        return instance;
    }

    public void park(Garage garage, Vehicle vehicle) throws Exception {
        Optional<Space> space = garage.findSpaceFor(vehicle);

        if (!space.isPresent()) {
            throw new Exception("No space available");
        }

        System.out.println("Parking in space of type " + space.get().getType().toString());
        space.get().park(vehicle);
    }

}
