package com.atul;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int n = 1000000007;
        System.out.println(n);

        //System.out.println(solve(4, 0, "", new ArrayList<>()));
        System.out.println(nSolve(0, 0, 4, 0, "", new ArrayList<>()));
    }


    public static List<String> nSolve(int ones, int zeros, int size, int idx, String cur, List<String> list) {
        if (idx == size) {
            list.add(cur);
            return list;
        }

        if (ones == zeros) {
            nSolve(ones + 1, zeros, size, idx + 1, cur + "1", list);
        } else if (ones > zeros) {
            nSolve(ones + 1, zeros, size, idx + 1, cur + "1", list);
            nSolve(ones, zeros + 1, size, idx + 1, cur + "0", list);
        }
        return list;
    }

    public static List<String> solve(int size, int idx, String cur, List<String> list) {
        if (size == idx) {
            list.add(cur);
            return list;
        }

        solve(size, idx + 1, cur + "0", list);
        solve(size, idx + 1, cur + "1", list);
        return list;
    }
}
