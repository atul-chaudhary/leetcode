package com.atul.contest;

import java.util.HashMap;
import java.util.Map;

public class CountNumberBadPairs {
    public static void main(String[] args) {
        int[] arr = {4,1,3,3};
        System.out.println(solve(arr));
    }

    /*
    long long countBadPairs(vector<int>& nums) {
        ll good_pairs = 0;
        ll n = nums.size();

        map<int, int> prv;
        for (int j = 0; j < n; j ++) {
            int cur = j - nums[j];
            good_pairs += prv[cur];
            prv[cur] ++;
        }

        ll total = n*(n-1)/2;
        return (total - good_pairs);
    }
     */

    private static long solve(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int gPair = 0;
        int n = nums.length;;
        for (int i = 0; i < nums.length; i++) {
            int cur = i-nums[i];
            gPair += map.getOrDefault(cur, 0);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        System.out.println(gPair);
        return ((long) n *(n-1)/2) - gPair;
    }

    public static long countBadPairsOP(int[] nums) {
        long unEqualCount = 0L;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i;
            Long equal = 0L;
            equal = map.getOrDefault(nums[i], 0L);
            map.put(nums[i], map.getOrDefault(nums[i], 0L) + 1);
            unEqualCount += i - equal;
        }
        return unEqualCount;
    }

    public static long countBadPairs(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i != nums[j] - nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
