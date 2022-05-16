package com.atul.strings;

import java.util.Arrays;

//leetcode 383
public class RansomNote {
    public static void main(String[] args) {
        String s1 = "bg";
        String s2 = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.println(canConstruct(s1, s2));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

     //int[] rasomNoteFrequency = new int[26];
     int[] magazinefrequency = new int[26];

//        for (int i = 0; i < ransomNote.length(); i++) {
//            rasomNoteFrequency[ransomNote.charAt(i)-97] = rasomNoteFrequency[ransomNote.charAt(i)-97]+1;
//        }

        //System.out.println(Arrays.toString(rasomNoteFrequency));
        for (int i = 0; i < magazine.length(); i++) {
            magazinefrequency[magazine.charAt(i)-97] = magazinefrequency[magazine.charAt(i)-97]+1;
        }
        System.out.println(Arrays.toString(magazinefrequency));
        for (int i = 0; i < ransomNote.length(); i++) {
//            if(magazinefrequency[ransomNote.charAt(i)-97] < rasomNoteFrequency[ransomNote.charAt(i)-97]){
//                return false;
//            }

            if(--magazinefrequency[ransomNote.charAt(i)- 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
