package com.atul.contest;

import java.util.*;

class c1 {
    public int x;
    private int y;
    protected int z;
}

class c2 extends c1{
    protected int a;
    private int b;
}

class c3 extends c2{
   private int q;

    public static void main(String[] args) {
       double num = 272.002;
       int num2 = 264;
       byte num3 = (byte) num;
       short num4 = (byte) num2;
        System.out.println(num3+ "<<>>"+num4);

    }
}


public class Contest04_06_2023 {
    public static void main(String[] args) {

    }


    public static int solve(int N, int K, int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order

        int rooms = 1; // Minimum number of rooms needed

        for (int i = 1; i < N; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) >= K) {
                // If the absolute difference between the current element and the previous element is greater than or equal to K,
                // assign the current element to the same room as the previous element.
                // Otherwise, assign the current element to a new room.
                rooms++;
            }
        }

        return rooms;
    }


    public static int minTrips(int[] floor, int K) {
        int n = floor.length;
        int trips = 0;

        Arrays.sort(floor); // Sort the floor array in ascending order

        int i = n - 1; // Start from the topmost floor
        while (i >= 0) {
            int capacity = K;

            // Calculate the number of candidates to be picked from the current floor
            while (i >= 0 && floor[i] > 0 && capacity > 0) {
                floor[i] -= Math.min(floor[i], capacity);
                capacity--;
                i--;
            }

            trips++; // Increment the number of trips

            // If there are still candidates remaining on the floors, go back to the topmost floor
            if (i >= 0 && floor[i] > 0) {
                trips++;
            }
        }

        return trips;
    }


    public static boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        boolean f = true;
        for (int i = 2; i < n; i++) {
            int cur_d = arr[i] - arr[i - 1];
            if (cur_d != d) {
                f = false;
            }
        }

        if (f) return true;
        return false;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        double slope = ((coordinates[1][0] - coordinates[0][0]) * 1.0) / (coordinates[1][1] - coordinates[0][1]);
        for (int i = 2; i < n; i++) {
            double slope_temp = ((coordinates[i][0] - coordinates[i - 1][0]) * 1.0) / (coordinates[i][1] - coordinates[i - 1][1]);
            if (slope_temp != slope) {
                return false;
            }
        }
        return true;
    }


    public int minimizedStringLength(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int oneIndex = -1;
        int nIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneIndex = i;
            }

            if (nums[i] == n) {
                nIndex = i;
            }
        }

        if (oneIndex > nIndex) {
            return (n - nIndex - 1) + (oneIndex) - 1;
        }

        return (n - nIndex - 1) + oneIndex;
    }

}
