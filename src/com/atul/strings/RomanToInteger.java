package com.atul.strings;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int num = 0;
        int n = s.length();
        int i=0;
        while(i < n){
            if(i+1 < n && s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                num+=map.get(""+s.charAt(i)+s.charAt(i+1));
                i+=2;
            }
            else if(i+1 < n && s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                num+=map.get(""+s.charAt(i)+s.charAt(i+1));
                i+=2;
            }
            else if(i+1 < n && s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                num+=map.get(""+s.charAt(i)+s.charAt(i+1));
                i+=2;
            }else {
                num += map.get("" + s.charAt(i));
                i++;
            }
        }
        return num;
    }
}
