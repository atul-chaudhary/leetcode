package com.atul.contest;

import java.util.List;

public class Contest26_03_2023 {
    public static void main(String[] args) {
        int one = 3;
        int zer = 2;
        int neg = 0;
        int k = 6;
        System.out.println(kItemsWithMaximumSum(one, zer, neg, k));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes > k) {
            return k;
        } else {
            if (numOnes + numZeros > k) {
                return numOnes;
            } else {
                int diff = k - (numOnes + numZeros);
                return numOnes - diff;
            }
        }
    }
}
