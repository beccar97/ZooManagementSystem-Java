package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Zebra extends AbstractAnimal implements LargeAnimal, CanBeGroomed {

    private LocalDateTime lastGroomed;

    public Zebra(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }

    @Override
    public LocalDateTime getLastGroomed() {
        return lastGroomed;
    }

    @Override
    public void setLastGroomed(LocalDateTime lastGroomed) {
        this.lastGroomed = lastGroomed;
    }
}
