package com.atul.contest;

import java.util.*;

public class Contest25_12_2022 {
    public static void main(String[] args) {
        int[] edges = {452712990,304923574,514804081,516542653,302633600,387844856,254193892,514125672,231231273,537828972,739788846,997137192,323638612,980131474,932473011,451725510,603721810,314059822,812497197,880888575,270244953,703545293,853537357,744164576,92185020,481926703,917558408,760008715,101971293};//{1, 2, 3, 4};
        int k = 778;
        System.out.println(countPartitions(edges, k));
    }

    static int mod = (int) 1e9 + 7;
    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for (int it : nums) {
            sum += it;
        }
        if (sum / 2 < k) return 0;

        //return solve(nums, sum, 0, k, 0);
        Long[][] dp = new Long[n+1][10001];

        long num = solveWrong(nums, 0, k, 0, dp);
        long pow = 1;
        for (int i = 1; i <= n; i++) {
            pow = ((pow % mod) * 2) % mod;
        }
        long ans = ((pow - ((2 * num) % mod)) + mod) % mod;
        return (int) ans;
    }

    private static long solveWrong(int[] nums, int curSum, int k, int index, Long[][] dp) {
        if (index >= nums.length) {
            if (curSum < k) return 1;
            return 0;
        }
        if(dp[index][curSum] != null) return dp[index][curSum];

        long pick = 0;
        if (curSum + nums[index] < k) {
            pick = solveWrong(nums, curSum + nums[index], k, index + 1, dp) % mod;
        }
        long notPick = solveWrong(nums, curSum, k, index + 1, dp) % mod;
        return dp[index][curSum] = (pick + notPick) % mod;
    }

    private static int solve(int[] nums, int total, int index, int k, int curSum) {
        if (index >= nums.length || curSum >= total) {
            if (curSum >= k && total - curSum >= k) {
                return 1;
            }
            return 0;
        }
        int pick = solve(nums, total, index + 1, k, curSum + nums[index]);
        int notPick = solve(nums, total, index + 1, k, curSum);
        return  pick + notPick;
    }

    public static int takeCharactersOpt(String s, int k) {
        int n = s.length();
        int totalCountA = 0;
        int totalCountB = 0;
        int totalCountC = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') totalCountA++;
            if (s.charAt(i) == 'b') totalCountB++;
            if (s.charAt(i) == 'c') totalCountC++;
        }
        if (totalCountA < k || totalCountB < k || totalCountC < k) return -1;
        int remCountA = totalCountA - k;
        int remCountB = totalCountB - k;
        int remCountC = totalCountC - k;
        int j = 0;
        int curA = 0;
        int curB = 0;
        int curC = 0;
        int curLen = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') curA++;
            if (s.charAt(i) == 'b') curB++;
            if (s.charAt(i) == 'c') curC++;

            while (j <= i && (curA > remCountA || curB > remCountB || curC > remCountC)) {
                if (s.charAt(j) == 'a') curA--;
                if (s.charAt(j) == 'b') curB--;
                if (s.charAt(j) == 'c') curC--;
                j++;
            }
            curLen = Math.max(curLen, i - j + 1);
        }

        return n - curLen;
    }

    //BINARY SEARCH ON Answer
    public int maximumTastinessOpt(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = price[n - 1] - price[0];
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean check = checkValid(mid, price, k);
            if (check) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean checkValid(int mid, int[] prices, int k) {
        int n = prices.length;
        int j = 0;
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[j] >= mid) {
                len++;
                j = i;
            }
        }

        if (len >= k) {
            return true;
        }

        return false;
    }


    public static int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        // count all the frq of string
        for (char ch : s.toCharArray()) arr[ch - 'a']++;
        System.out.println(Arrays.toString(arr));

        // if total frq of any char is less than k return -1;
        if (arr[0] < k || arr[1] < k || arr[2] < k) return -1;
        int ans = arr[0] + arr[1] + arr[2];
        int st = 0;

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']--;

            // if any char length is less than k then increase start position
            if (arr[0] < k || arr[1] < k || arr[2] < k) {
                //get the min ans
                ans = Math.min(arr[0] + arr[1] + arr[2] + 1, ans);
                while (s.charAt(st) != ch) {
                    arr[s.charAt(st) - 'a']++;
                    st++;
                }
                arr[ch - 'a']++;
                st++;
            }
        }
        ans = Math.min(arr[0] + arr[1] + arr[2], ans);

        return ans;
    }

    public static int maximumTastiness(int[] price, int k) {
        Integer[][] dp = new Integer[price.length + 1][k + 1];
        return solve(price, 0, 0, k, new ArrayList<>(), dp);
    }

    private static int solve(int[] arr, int index, int curNum, int k, List<Integer> list, Integer[][] dp) {
        if (curNum == k) {
            int ans = twoMax(list);
            System.out.println(list + " ans " + ans);
            return ans;
        }

        if (index >= arr.length) {
            return Integer.MIN_VALUE;
        }

        list.add(arr[index]);
        int pick = solve(arr, index + 1, curNum + 1, k, list, dp);
        list.remove(list.size() - 1);
        int notPick = solve(arr, index + 1, curNum, k, list, dp);

        return dp[index][curNum] = Math.max(pick, notPick);
    }

    private static int twoMax(List<Integer> nums) {
        int n = nums.size();
        List<Integer> arr = new ArrayList<>(nums);
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        return min;
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        if (!hashSet.contains(target)) return -1;
        if (words[startIndex].equals(target)) return 0;
        int n = words.length;
        int right = (startIndex + 1) % n;
        int rightCount = 1;
        while (right != startIndex) {
            if (words[right].equals(target)) {
                break;
            }
            rightCount++;
            right = (right + 1) % n;
        }
        int leftCount = 1;
        int left = (startIndex - 1 + n) % n;
        while (left != startIndex) {
            if (words[left].equals(target)) {
                break;
            }
            leftCount++;
            left = (left - 1 + n) % n;
        }
        return Math.min(leftCount, rightCount);
    }
}
