package com.atul.LLD.parkingLot;

public class Slot {
    int slotNumber;
    VehicleType vehicleType;
    boolean isOccupied;

    public Slot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Slot(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Slot(VehicleType vehicleType, boolean isOccupied) {
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
    }
}
