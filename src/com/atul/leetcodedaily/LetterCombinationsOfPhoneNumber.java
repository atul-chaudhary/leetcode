package com.atul.leetcodedaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        letterCombinations("");
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, char[]> hashMap= new HashMap<>();
        hashMap.put(1,null);
        hashMap.put(2, new char[]{'a', 'b', 'c'});
        hashMap.put(3,new char[]{'d','e','f'});
        hashMap.put(4,new char[]{'g','h','i'});
        hashMap.put(5,new char[]{'j','k','l'});
        hashMap.put(6,new char[]{'m','n','o'});
        hashMap.put(7,new char[]{'p','q','r','s'});
        hashMap.put(8,new char[]{'t','u','v'});
        hashMap.put(9,new char[]{'w','x','y', 'z'});

        String s1 = "abc";
        String s2 = "def";
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s1.charAt(i));
                stringBuilder.append( s2.charAt(j));
                arrayList.add(stringBuilder);
            }
        }
        System.out.println(arrayList);
        return null;
    }
}
