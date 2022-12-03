package com.atul.strings;

import java.util.*;
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String s1 = "uau";
        String s2 = "ssx";
        System.out.println(closeStrings(s1,s2));
    }

    public static boolean closeStrings(String s1, String s2) {
        int n =  s1.length();
        int m = s2.length();

        if(n != m) return false;
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i=0;i<n;i++){
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i),0)+1);
            m2.put(s2.charAt(i), m2.getOrDefault(s2.charAt(i),0)+1);
        }
        int size = m1.size();
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        int i=0;
        for (Map.Entry<Character, Integer> entry : m1.entrySet()){
            arr1[i++] = entry.getValue();
        }
        i=0;
        for (Map.Entry<Character, Integer> entry : m2.entrySet()){
            arr2[i++] = entry.getValue();
        }
        if (!m1.keySet().equals(m2.keySet())) {
            return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int j = 0; j < size; j++) {
            if(arr1[j] != arr2[j]){
                return false;
            }
        }
        return true;
    }
}
