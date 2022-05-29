package com.atul.contest;

import java.util.HashMap;

public class RearrangeCharactersToMakeTargetString {
    public static void main(String[] args) {
        String s  = "abbaccaba";//"codecodecodecode";
        String t = "aaaa";//"codecode";
        String temp = "$100";
        System.out.println(temp.substring(1, temp.length()));
        System.out.println(rearrangeCharacters(s,t));
    }

    public static int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int tarLen = target.length();
        int[] arr = new int[tarLen];
        for(int i=0;i<target.length();i++){
            char c= target.charAt(i);
            if(!map.containsKey(c)){
                return 0;
            }else {
                map.put(c, map.get(c)-1);
                arr[i] = map.get(c);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<tarLen;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        return min;
    }
}
