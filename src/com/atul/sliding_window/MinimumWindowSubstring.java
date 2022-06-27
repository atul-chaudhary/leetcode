package com.atul.sliding_window;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String result = "";
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> tmap = new HashMap<>();
        int tcount = 0;
        for(int i=0;i<t.length();i++){
            tcount++;
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i),0)+1);
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        int curCount = 0;
        while(end < s.length()){
            //here we are acquiring the character
            char endChar = s.charAt(end);
            smap.put(endChar, smap.getOrDefault(endChar,0)+1);

            //only increasing the curCount when the current Character is valid
            if(tmap.containsKey(endChar)){
                if(smap.get(endChar) <= tmap.get(endChar)){
                    curCount++;
                }
            }

            while(curCount == tcount){
                //collecting result
                String str = s.substring(start, end+1);
                if(result.length() == 0 || str.length() < result.length()){
                    result = str;
                }

                //performing removing operation
                char startChar = s.charAt(start);
                smap.put(startChar, smap.get(startChar) -1);

                //decreasing the current count beacuse we have lost the valid character
                if(tmap.containsKey(startChar)){
                    if(smap.get(startChar) < tmap.get(startChar)){
                        curCount--;
                    }
                }

                if(smap.get(startChar)==0){
                    smap.remove(startChar);
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
