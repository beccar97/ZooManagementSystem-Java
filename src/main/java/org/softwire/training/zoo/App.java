package org.softwire.training.zoo;

import org.softwire.training.zoo.models.*;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;
import org.softwire.training.zoo.services.Scheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = getLargeAnimals();
        List<SmallAnimal> smallAnimals = getSmallAnimals();
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        List<? extends Scheduler> schedulers = getSchedulers();
        schedulers.forEach(scheduler -> scheduler.assignJobs(keepers));
        animals.forEach(System.out::println);
    }

    private static List<? extends Scheduler> getSchedulers() {
        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();

        return Arrays.asList(feedingScheduler, groomingScheduler);
    }

    private static List<LargeAnimal> getLargeAnimals() {
        return Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Tiger(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1))
        );
    }

    private static List<SmallAnimal> getSmallAnimals() {
        return Arrays.asList(
                new Rabbit(LocalDate.of(2017, 6, 4)),
                new Rabbit(LocalDate.of(2014, 1, 1))
       );
    }
}
