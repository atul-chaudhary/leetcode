package com.atul.greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println(map);
        int num = 0;
        for(Map.Entry<Character, Integer> ent : map.entrySet()){
            Character ch = ent.getKey();
            int val = ent.getValue();
            if(val %2 ==0){
                num+=val;
                map.put(ch, 0);
            }else if(val > 1 && val %2 ==1){
                num+= val-1;
                map.put(ch, 1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> ent : map.entrySet()){
            if(ent.getValue() > 0){
                num+=ent.getValue();
                break;
            }
        }
        return num;
    }
}
