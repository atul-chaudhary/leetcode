package com.atul.contest;

import javax.security.auth.login.CredentialException;
import java.util.HashMap;
import java.util.Map;

public class RemoveLetterToEqualizeFrequency {
    public static void main(String[] args) {
        String s = "abcc";
        System.out.println(equalFrequencyOpt(s));
    }

    public static boolean equalFrequencyOpt(String word) {
        for (int i = 0; i < word.length(); i++){
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                if(i != j){
                    map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);

                }
            }
            boolean flag = true;
            int k=0;
            int first = 0;
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(k==0){
                    first = entry.getValue();
                    k++;
                }else{
                    if(first != entry.getValue()) flag = false;
                }

            }

            if(flag){return true;};
        }

        return false;
    }

    public static boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        System.out.println(map);
        Map<Integer, Integer> fre = new HashMap<>();
        for (Map.Entry<Character, Integer> ent : map.entrySet()) {
            fre.put(ent.getValue(), fre.getOrDefault(ent.getValue(), 0) + 1);
        }
        System.out.println(fre);
        if (fre.size() > 2) {
            return false;
        } else if (fre.size() == 1) {
            System.out.println();
            for (Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() == 1 && map.size() > 2) return true;
            }
            return false;
        } else if (fre.size() == 2) {
            int[] res = new int[2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
                res[i++] = entry.getKey();
            }
            if (Math.abs(res[0] - res[1]) == 1) {
                return true;
            }
        }
        return false;
    }
}
