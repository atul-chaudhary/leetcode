package com.atul.contest;

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand {
    public static void main(String[] args) {
        int[] ranks = {4,4,2,4,4};
        char[] suits = {'d','a','a','b','c'};
        System.out.println(bestHand(ranks, suits));
    }

    public static String bestHand(int[] ranks, char[] suits) {
        char c = suits[0];
        boolean isFlush = true;
        for(int i=1;i<suits.length;i++){
            if(suits[i] != c){
                isFlush = false;
            }
        }
        if(isFlush){
            return "Flush";
        }else{
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<ranks.length;i++){
                map.put(ranks[i], map.getOrDefault(ranks[i],0)+1);
            }
            boolean isThree = false;
            boolean isPair = false;
            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                if(e.getValue() >= 3){
                    isThree = true;
                }else if(e.getValue() == 2){
                    isPair = true;
                }
            }

            if(isThree) return "Three of a Kind";
            else if(isPair) return "Pair";
            else return "High Card";
        }
    }
}
