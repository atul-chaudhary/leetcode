package com.atul.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TheAttackOfKnight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> queries = new ArrayList<>();
        for (int i = 0; i < test; i++) {
            ArrayList<int[]> cur = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String[] s = br.readLine().split(" ");
                int[] temp = new int[s.length];
                temp[0] = Integer.parseInt(s[0]);
                temp[1] = Integer.parseInt(s[1]);
                cur.add(temp);
            }
            queries.add(cur);
        }
        //System.out.println(queries);
//        for(ArrayList<int[]> s: queries){
//            for (int[] q: s){
//                System.out.print(Arrays.toString(q));
//            }
//            System.out.println();
//        }
        for (int i = 0; i < test; i++) {
            int[] p1, p2, p3, p4, p5, p6, p7, p8;
            int x = 8;
            int y = 8;

            int x1 = queries.get(i).get(0)[0];
            int y1 = queries.get(i).get(0)[1];

            //if(x1)
        }
    }
}
