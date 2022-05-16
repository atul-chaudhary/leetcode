package com.atul.strings;

import java.util.Arrays;
import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqCharNew(s));

    }

    ///instead of taking  hashmap we can also use the array of length 26 where we can store the occurence of each character
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }


    //using array instead of hashmap
    public static int firstUniqCharNew(String s) {
        int[] frequency = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int c = s.charAt(i) - 97;
            frequency[c] = frequency[c]+1;
        }
        System.out.println(Arrays.toString(frequency));
        int index = -1;
        for (int i=0;i<length;i++){
            if(frequency[s.charAt(i)-97]==1){
                index = i;
                break;
            }
        }
        return index;
    }
}
