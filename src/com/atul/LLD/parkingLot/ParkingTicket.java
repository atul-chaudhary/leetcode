package com.atul.LLD.parkingLot;

import java.time.LocalDateTime;

public class ParkingTicket {
    int slotNumber;
    int level;
    LocalDateTime entryDateTime;
    LocalDateTime existDateTime;
    double amount;

    public ParkingTicket(int level, int slotNumber, LocalDateTime entryDateTime) {
        this.slotNumber = slotNumber;
        this.level = level;
        this.entryDateTime = entryDateTime;
    }

}
