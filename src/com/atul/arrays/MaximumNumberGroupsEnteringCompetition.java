package com.atul.arrays;

public class MaximumNumberGroupsEnteringCompetition {
    public static void main(String[] args) {
        System.out.println(maximumGroups(new int[]{10,6,12,7,3,5}));
    }

    public static int maximumGroups(int[] grades) {
        int count = 1;
        int sum = 1;
        int result = 0;
        while(sum <= grades.length){
            count++;
            sum+=count;
            result++;
        }
        return result;
    }
}
