package com.atul.contest;

public class MinimumHoursOfTrainingWinCompetition {
    public static void main(String[] args) {
        int en = 5;
        int ex = 3;
        int [] eno = {1,4};
        int[] exo = {2,5};
        System.out.println(minNumberOfHours(en, ex, eno, exo));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int training = 0;
        int sumE = 0;
        for(int it : energy){
            sumE+=it;
        }
        if(initialEnergy <= sumE) {
            training += sumE - initialEnergy + 1;
        }
        int i=0;
        int inex = initialExperience;
        int count = 0;
        while(i < energy.length){
            for (int j = 0; j < experience.length; j++) {
                if(inex > experience[i]){
                    inex+=experience[i];
                    i++;
                }else{
                    i=0;
                    count++;
                    inex = initialExperience + count;
                    training++;
                    break;
                }
            }
        }
        return training;
    }
}
