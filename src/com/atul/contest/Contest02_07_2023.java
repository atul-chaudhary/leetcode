package com.atul.contest;

import java.util.*;

public class Contest02_07_2023 {
    public static void main(String[] args) {
        long[] nums = {1, 3, 5, 5, 5, 5, 14, 65};
        //System.out.println(searchInSorted(nums, nums.length, 5));
        System.out.println(find(nums, nums.length, 5));
    }

    static ArrayList<Long> find(long arr[], int n, int x) {
        // code here
        int first = 0;
        int last = n - 1;
        int index = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                index = mid;
                first = mid + 1;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        System.out.println(index);
        return null;
    }

    static int searchInSorted(int arr[], int N, int K) {
        int n = arr.length;
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (K == arr[mid]) {
                return mid;
            } else if (K < arr[mid]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            if (sum >= target) {
                len = Math.min(len, j - i + 1);
                while (sum > target) {
                    sum -= nums[i];
                    len = Math.min(len, j - i + 1);
                    i++;
                }
                if (sum == target) {
                    len = Math.min(len, j - i + 1);
                }
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }


    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeros++;
            if (nums[i] == 1) ones++;

            if (nums[i] == 1) continue;
            int temp = i - 1;
            int first = 0;
            while (temp >= 0 && nums[temp] == 1) {
                first++;
                temp--;
            }
            int second = 0;
            temp = i + 1;
            while (temp < n && nums[temp] == 1) {
                second++;
                temp++;
            }
            ans = Math.max(ans, first + second);
        }
        if (zeros == 0) ans = ones - 1;
        return ans;
    }

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) continue;
            return entry.getKey();
        }
        return -1;
    }

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (j < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > 1 && map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        if (n == 1) {
            if (nums[0] % 2 == 0 && nums[0] <= threshold) {
                return 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                ans = Math.max(ans, 1);
                for (int j = i; j < n; j++) {
                    if (j < n - 1) {
                        if (nums[j] % 2 != nums[j + 1] % 2) {
                            ans = Math.max(ans, j - i + 1);
                        }
                    } else {
                        if (nums[j] <= threshold) {
                            ans = Math.max(ans, j - i + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int first = i;
            int second = n - first;

            if ((vis[first] && vis[second]) || (isPrime(first, vis) && isPrime(second, vis))) {
                if (second < first) {
                    return result;
                }
                if (first + second == n) {
                    List<Integer> nums = new ArrayList<>();
                    nums.add(first);
                    nums.add(second);
                    result.add(nums);
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int n, boolean[] vis) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        vis[n] = true;
        return true;
    }
}
