package com.atul.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountTheACs {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            int score = Integer.parseInt(br.readLine());
            if(score == 0){
                System.out.println(0);
            }else {
                System.out.println(scoreCheck(score));
            }
        }
    }

    private static int scoreCheck(int score){
        if(score <= 10){
            return score;
            //System.out.println(score);
        }else if(score > 10 && score < 100){
            return -1;
            //System.out.println(-1);
        }
        int result = scoreCheck(score-100);
        if(result > 10){
            return -1;
        }
        return result != -1 ? result + 1 > 10 ? -1 : result+1: result;
    }
}

