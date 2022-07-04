package com.atul.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DecodeTheMessage {
    public static void main(String[] args) {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";//"the quick brown fox jumps over the lazy dog";
        String mess = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";//"vkbs bs t suepuv";
        System.out.println(decodeMessage(key, mess));
    }

    public static String decodeMessage(String key, String message) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> keyMap = new HashMap<>();
        int j=0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<key.length();i++){
            if(key.charAt(i) != ' ' && !set.contains(key.charAt(i)) && j < 26){
                keyMap.put(key.charAt(i), j);
                set.add(key.charAt(i));
                j++;
            }else if(j >= 26){
                break;
            }
        }
        for(int i=0;i<message.length();i++){
            if(message.charAt(i) != ' '){
                result.append((char)(keyMap.get(message.charAt(i)) + 'a'));
            }else if(message.charAt(i) == ' '){
                result.append(" ");
            }
        }
        return result.toString();
    }
}

