package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public abstract class Scheduler {
    private Scheduler instance;
    public abstract void assignJobs(List<Keeper<? extends Animal>> keepers);

}
