package org.softwire.training.zoo.models;

import java.time.LocalDateTime;

public interface CanBeGroomed {
    LocalDateTime getLastGroomed();
    void setLastGroomed(LocalDateTime time);

    default void groom(){
        setLastGroomed(LocalDateTime.now());
    };
}
