package com.atul.contest;

import java.util.*;

public class Contest27_08_2023 {

    public static void main(String[] args) {
        String str = "LR";
        System.out.println(furthestDistanceFromOrigin(str));
    }



    public static int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int max = 0;
        int space = 0;
        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if (ch == '_') {
                space++;
            } else {
                max = ch == 'L' ? -1 : 1;
            }
        }
        return Math.abs(max)+space;
    }

    private static int solveRight(String moves, char cur, int index) {
        int temp = 0;
        for (int i = index; i < moves.length(); i++) {
            if (moves.charAt(i) == '_' || moves.charAt(i) == cur) {
                temp++;
            } else if (moves.charAt(i) != cur) {
                break;
            }
        }
        return temp;
    }

    private static int solveLeft(String moves, char cur, int index) {
        int temp = 0;
        for (int i = index; i >= 0; i--) {
            if (moves.charAt(i) == '_' || moves.charAt(i) == cur) {
                temp++;
            } else if (moves.charAt(i) != cur) {
                break;
            }
        }
        return temp;
    }

    public static long minimumPossibleSum(int n, int target) {
        int num = 1;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        while (list.size() < n) {
            if (!set.contains(target - num)) {
                list.add(num);
                set.add(num);
            }
            num++;
        }

        long sum = 0;
        for (int it : list) {
            sum += it;
        }
        return sum;
    }
}
