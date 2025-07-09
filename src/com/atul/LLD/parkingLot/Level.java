package com.atul.LLD.parkingLot;

import java.util.Set;
import java.util.TreeSet;

public class Level {
    int levelNumber;
    Slot[] slots;

    public Level(int levelNumber, Slot[] slots) {
        this.levelNumber = levelNumber;
        this.slots = slots;
    }
}
