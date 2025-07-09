package com.atul.LLD.parkingLot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExistGate {

    public void takeExist(User user){
        ParkingTicket userParkingTicket = user.parkingTicket;
        LocalDateTime exitTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(userParkingTicket.entryDateTime, exitTime);
        return;
    }
}
