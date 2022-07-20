package com.atul.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheLastLevels {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            int count = 0;
            int total = 0;
            for(int j=1;j<=x;j++){
                if(count == 3){
                    count =0;
                    total+=z;
                }
                total+=y;
                count++;
            }
            System.out.println(total);
        }
    }
}
