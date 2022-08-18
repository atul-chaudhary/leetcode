package com.atul.strings;

import java.util.HashSet;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] s = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(s));
    }
    static String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public static int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String trans = getTrans(words[i]);
            set.add(trans);
        }
        return set.size();
    }

    private static String getTrans(String words){
        String result = "";
        for (int i = 0; i < words.length(); i++) {
            result+=morseCode[words.charAt(i)-'a'];
        }
        return result;
    }
}
