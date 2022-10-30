package com.atul.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OddStringDifference {
    public static void main(String[] args) {
        String[] words = {"aaa","bob","ccc","ddd"};
        System.out.println("word".toCharArray());
        char[] temp  = "joke".toCharArray();
        int sum = 0;
        for(char ch : temp){
            sum+= (int)ch-'a';
        }
        System.out.println(sum);
        System.out.println(oddString(words));
    }

    static class Pair{
        int freq;
        int index;

        public Pair(int freq, int index) {
            this.freq = freq;
            this.index = index;
        }
    }
    public static String oddString(String[] words) {
        Map<ArrayList<Integer>, Pair> map = new HashMap<>();
        for(int j=0;j<words.length;j++){
            String s =  words[j];
            int n = s.length();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                arrayList.add(((int)s.charAt(i)-'a') - ((int)s.charAt(i-1)-'a'));
            }
            if(map.containsKey(arrayList)){
                map.put(arrayList, new Pair(map.get(arrayList).freq+1, j));
            }else{
                map.put(arrayList, new Pair(1, j));
            }
        }
        String result = "";
        for (Map.Entry<ArrayList<Integer>, Pair> entry : map.entrySet()){
            if(entry.getValue().freq == 1){
                result = words[entry.getValue().index];
            }
        }
        return result;
    }
}
