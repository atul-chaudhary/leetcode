package com.atul.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {
    public static void main(String[] args) {
        String s = "repggxrpnrvy";
        System.out.println(longestkSubstrOtp(s, 12));
    }

    public static int longestkSubstrOtp(String s, int k) {
        if(k==0 || k > s.length() || s.length() ==0 || s == null){
            return -1;
        }
        // code here
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0)+1);

            if(map.size() > k){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);

                if(map.get(startChar) == 0){
                    map.remove(startChar);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        System.out.println(map.size());
        return maxLength;
    }

    public static int longestkSubstr(String s, int k) {
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Character> temp  =new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                temp.add(s.charAt(j));
                arr.add(new ArrayList<>(temp));
            }
        }
        int max = -1;
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Character> arrayList = arr.get(i);
            HashSet<Character> hashSet = new HashSet<Character>(arrayList);
            if(hashSet.size() == 3){
                max = Math.max(arrayList.size(), max);
            }
        }

        //System.out.println(max);
        return max;
    }
}
