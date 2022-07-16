package com.atul.strings;

import java.io.Serializable;
import java.util.HashMap;

public class IsomorphicStrings implements Serializable {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }


    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (smap.containsKey(s.charAt(i))) {
                if (smap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if(tmap.containsKey(t.charAt(i))){
                if(tmap.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else {
                smap.put(s.charAt(i), t.charAt(i));
                tmap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
