package com.atul.contest;


import java.util.*;

public class Contest08012023 {
    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "bb";
        System.out.println(isItPossible(word1, word2));
    }



    public static boolean isItPossible(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] word1Fre = new int[26];
        int[] word2Fre = new int[26];
        for (int i = 0; i < n; i++) {
            word1Fre[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            word2Fre[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (word1Fre[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (word2Fre[j] == 0) continue;
                word1Fre[i]--;
                word1Fre[j]++;

                word2Fre[j]--;
                word2Fre[i]++;
                if (isEqual(word1Fre, word2Fre)) {
                    return true;
                }

                word1Fre[i]++;
                word1Fre[j]--;

                word2Fre[j]++;
                word2Fre[i]--;
            }
        }
        return false;
    }

    private static boolean isEqual(int[] word1Fre, int[] word2Fre) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 26; i++) {
            if (word1Fre[i] > 0) {
                count1++;
            }

            if (word2Fre[i] > 0) {
                count2++;
            }
        }
        if (count1 == count2) return true;
        return false;
    }

    public static int maximumCount(int[] nums) {
        int neg = 0;
        int post = 0;
        for (int it : nums) {
            if (it < 0) {
                neg++;
            }

            if (it > 0) {
                post++;
            }
        }
        return Math.max(post, neg);
    }

    public static long maxKelements(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : nums) {
            pq.offer(it);
        }
        long result = 0;
        while (k > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            result += num;
            pq.offer((int) Math.ceil(num * 1.0 / 3));
            k--;
        }
        return result;
    }
}
