package com.atul.LLD.parkingLot;

import java.util.Scanner;

public class ParkingLot {
    Level[] levels;
    EntryGate entryGate;
    ExistGate existGate;

    public void initializeParkingLot() {
        //define the number of level
        Scanner scanner = new Scanner(System.in);
        System.out.println("define the level in parking lot");
        int level = Integer.parseInt(scanner.next());
        String[] typesParking = scanner.next().split(" ");
        int car = Integer.parseInt(typesParking[0]);
        int bike = Integer.parseInt(typesParking[1]);
        Level[] levels = new Level[level];
        for (int i = 0; i < level; i++) {
            Slot[] slots = new Slot[car + bike];
            for (int j = 0; j < car; j++) {
                slots[j] = new Slot(VehicleType.CAR);
            }
            for (int j = car; j < car + bike; j++) {
                slots[j] = new Slot(VehicleType.BIKE);
            }
            levels[i] = new Level(i, slots);
        }

        entryGate = new EntryGate();
        existGate = new ExistGate();
    }

    public void ParkVehicle(User user) {
        int[] canUserParkVehicle = entryGate.isParkingAvailable(levels, user);
        int levelNumber = canUserParkVehicle[0];
        int slotNumber = canUserParkVehicle[1];
        if (levelNumber != -1 && slotNumber != -1) {
            entryGate.assignEntry(user, levels, canUserParkVehicle);
        } else {
            System.out.println("No Parking available");
        }
    }

    public void exitFromParking(User user) {
        existGate.takeExist(user);
    }
}
