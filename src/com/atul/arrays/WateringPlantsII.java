package com.atul.arrays;

public class WateringPlantsII {

    public static void main(String[] args) {
        int[] plants = {1, 2, 4, 4, 5};
        int acap = 6;
        int bcap = 5;

        System.out.println(minimumRefill(plants, acap, bcap));
    }


    public static int minimumRefill(int[] plants, int acap, int bcap) {
        int len = plants.length;

        int i = 0;
        int j = len - 1;

        int aliceCap = acap;
        int bobCap = bcap;

        int refil = 0;
        while (i <= j) {

            if (i == j) {
                if (aliceCap >= bobCap) {
                    if (aliceCap >= plants[i]) {
                        aliceCap -= plants[i];
                    } else {
                        refil++;
                        aliceCap = acap;
                        aliceCap -= plants[i];
                    }
                } else {

                    if (bobCap >= plants[j]) {
                        bobCap -= plants[j];
                    } else {
                        refil++;
                        bobCap = bcap;
                        bobCap -= plants[j];
                    }

                }
            } else {
                if(aliceCap < plants[i]){
                    refil++;
                    aliceCap = acap;
                }
                aliceCap -= plants[i];

                if(bobCap < plants[j]){
                    refil++;
                    bobCap = bcap;
                }
                bobCap -= plants[j];
            }
            i++;
            j--;
        }

        return refil;
    }

}
