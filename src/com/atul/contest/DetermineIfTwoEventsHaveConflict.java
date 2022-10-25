package com.atul.contest;

public class DetermineIfTwoEventsHaveConflict {
    public static void main(String[] args) {
        String[] event1 = {"16:53","19:00"};
        String [] event2 = {"10:33","18:15"};
        System.out.println(haveConflict(event1, event2));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        String[] evstart1 = event1[0].split(":");
        String[] evEnd1 = event1[1].split(":");

        double evStartD = Double.parseDouble(evstart1[0]+"."+evstart1[1]);
        double evEndD  = Double.parseDouble(evEnd1[0]+"."+evEnd1[1]);


        String[] evstart2 = event2[0].split(":");
        String[] evEnd2 = event2[1].split(":");
        double evStart2D = Double.parseDouble(evstart2[0]+"."+evstart2[1]);
        double evEnd2D  = Double.parseDouble(evEnd2[0]+"."+evEnd2[1]);

        if(evStart2D <= evEndD && evStart2D >= evStartD || (evStartD >= evStart2D && evStartD <= evEnd2D)){
            return true;
        }
        return false;
    }
}
