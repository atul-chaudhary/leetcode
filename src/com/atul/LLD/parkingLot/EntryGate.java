package com.atul.LLD.parkingLot;

import java.time.LocalDateTime;

public class EntryGate {
    public int[] isParkingAvailable(Level[] levels, User user) {
        VehicleType vehicleType = user.vehicle.vehicleType;
        for (Level level : levels) {
            for (Slot slot : level.slots) {
                if (slot.vehicleType == vehicleType && slot.isOccupied == true) {
                    return new int[]{level.levelNumber, slot.slotNumber};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public void assignEntry(User user, Level[] levels, int[] parkingInfo) {
        int level = parkingInfo[0];
        int slotNumber = parkingInfo[1];
        levels[level].slots[slotNumber].isOccupied = true;
        user.parkingTicket = new ParkingTicket(level, slotNumber, LocalDateTime.now());
    }
}
