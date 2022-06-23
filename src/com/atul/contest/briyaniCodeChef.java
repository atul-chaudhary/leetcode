package com.atul.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class briyaniCodeChef {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bufferedReader.readLine());
        System.out.println(test);
        ArrayList<int[]> queries = new ArrayList<>();
        for(int i=0;i<test;i++){
            String[] s  = bufferedReader.readLine().split( " ");
            int[] temp = new int[s.length];
            temp[0] = Integer.parseInt(s[0]);
            temp[1] = Integer.parseInt(s[1]);
            queries.add(temp);
        }

        for(int i=0;i<queries.size();i++){
            System.out.println(queries.get(i)[0]*queries.get(i)[1]);
        }
    }
}
