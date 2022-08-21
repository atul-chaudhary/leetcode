package com.atul.contest;

public class TimeNeededToRearrangeABinaryString {
    public static void main(String[] args) {
        String s = "11100";
        System.out.println(secondsToRemoveOccurrences(s));
    }

    public static int secondsToRemoveOccurrences(String s) {
        if(!s.contains("01")){
            return 0;
        }else{
            int count = 0;
            while(true){
                if(s.contains("01")) {
                    s = s.replaceAll("01", "10");
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
    }
}
