package org.softwire.training.garage;

import org.softwire.training.garage.models.garage.FloorPlan;
import org.softwire.training.garage.models.garage.Garage;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Garage garage = initGarage();
    }

    static Garage initGarage() {
        List<FloorPlan>  floorPlans = Arrays.asList(
                new FloorPlan(25, 5, 5,0),
                new FloorPlan(50, 10, 0 ,0),
                new FloorPlan(50, 10, 0 ,0),
                new FloorPlan(50, 10, 0 ,0),
                new FloorPlan(25, 0 , 0, 25)
        );

        return new Garage(floorPlans);
    }
}