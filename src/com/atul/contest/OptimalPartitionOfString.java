package com.atul.contest;

import java.util.HashMap;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        String s = "ssssss";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        int n = s.length();
        int first = 0;
        int last = 0;
        int part = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!solve(first, last, s)){
                part++;
                first = i;
                last = i;
            }
            last++;
        }
        return part+1;
    }

    private  static boolean solve(int first, int last, String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = first;i<=last;i++){
            if(map.containsKey(s.charAt(i))){
                return false;
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        return true;
    }
}
