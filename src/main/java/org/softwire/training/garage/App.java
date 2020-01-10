package org.softwire.training.garage;

import org.softwire.training.garage.models.garage.FloorPlan;
import org.softwire.training.garage.models.garage.Garage;
import org.softwire.training.garage.models.vehicles.Car;
import org.softwire.training.garage.models.vehicles.Coach;
import org.softwire.training.garage.models.vehicles.Motorbike;
import org.softwire.training.garage.service.Valet;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Garage garage = initGarage();

        Valet valet = Valet.getInstance();

        Car car = new Car("Laioshfh", false, true);
        Coach coach = new Coach("asioh");
        Motorbike motorbike = new Motorbike("ioahh");

        valet.park(garage, coach);
        valet.park(garage, car);
        valet.park(garage, motorbike);

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