package com.atul.contest;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsDictionary {
    public static void main(String[] args) {
        String[] que = {"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"};
        String[] dict = {"uyj","bug","dba","xbe","blu","wuo","tsf","tga"};

        //System.out.println(calDiff("word", "wood"));
        System.out.println(twoEditWords(que, dict));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String que : queries){
            for (String dict : dictionary){
                if(calDiff(que, dict)) {
                    result.add(que);
                    break;
                };
            }
        }
        return result;
    }


    private static boolean calDiff(String a, String b){
        int n = a.length();
        int same = 0;
        for (int i = 0; i < n; i++) {
            if(a.charAt(i)==b.charAt(i)){
                same++;
            }
        }
        if(n-same<=2){
            return true;
        }else return false;
    }
}
