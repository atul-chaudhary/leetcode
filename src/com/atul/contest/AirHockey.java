package com.atul.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AirHockey {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        ArrayList<int[]> queries = new ArrayList<>();
        for(int i=0;i<test;i++){
            String[] s = br.readLine().split(" ");
            int[] temp = new int[s.length];
            temp[0] = Integer.parseInt(s[0]);
            temp[1] = Integer.parseInt(s[1]);
            queries.add(temp);
        }

        for(int i=0;i<queries.size();i++){
            int max = Math.max(queries.get(i)[0], queries.get(i)[1]);
            System.out.println(7-max);
        }
    }
}
