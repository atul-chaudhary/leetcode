package com.atul.strings;

import java.util.HashSet;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {

    }
    String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String trans = getTrans(words[i]);
            set.add(trans);
        }
        return set.size();
    }

    private String getTrans(String words){
        String result = "";
        for (int i = 0; i < words.length(); i++) {
            System.out.println(words.charAt(i)-'a');
            result+=morseCode[words.charAt(i)-'a'];
        }
        return result;
    }
}
