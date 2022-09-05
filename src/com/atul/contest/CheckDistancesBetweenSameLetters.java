package com.atul.contest;

import java.util.HashMap;

public class CheckDistancesBetweenSameLetters {
    public static void main(String[] args) {
        String s  = "aa";
        int[] dp = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(checkDistances(s, dp));
    }

    public static boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                int ke = map.get(s.charAt(i));
                if(i-ke- 1!= distance[s.charAt(i)-'a']){
                    return false;
                }
            }else{
                map.put(s.charAt(i), i);
            }
        }
        return true;
    }
}
