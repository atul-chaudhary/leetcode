package com.atul.contest;

import java.util.*;

public class Contest_19_11_2023 {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static int countCharacters(String[] words, String chars) {
        int n = words.length;
        int m = chars.length();
        Map<Character, Integer> charsMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char ch = chars.charAt(i);
            charsMap.put(ch, charsMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (check(words[i], chars, charsMap)) {
                ans += words[i].length();
            }
        }
        return ans;
    }

    private static boolean check(String cur, String chars, Map<Character, Integer> charsMap) {
        if (cur.equals(chars)) return true;
        Map<Character, Integer> map = new HashMap<>();
        int n = cur.length();
        for (int i = 0; i < n; i++) {
            char ch = cur.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (!charsMap.containsKey(key)) {
                return false;
            }
            if (charsMap.get(key) < value) {
                return false;
            }
        }
        return true;
    }

    public static int minimumCoins(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n + 1][n + 1];

        return solve(0, 0, prices, dp);
        //return solve(prices, 0, dp);
    }

    public static int solve(int i, int free, int[] prices, Integer[][] dp) {
        if (i >= prices.length)
            return 0;
        if (dp[i][free] != null)
            return dp[i][free];
        int take = solve(i + 1, i + 1, prices, dp) + prices[i];
        int nottake = Integer.MAX_VALUE;
        if (free > 0) {
            nottake = solve(i + 1, free - 1, prices, dp);
        }
        return dp[i][free] = Math.min(take, nottake);
    }

    private static int solve(int[] nums, int index, Integer[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != null) return dp[index];
        int leaveNext = nums[index] + solve(nums, index + index + 1, dp);
        int pickNext = nums[index] + solve(nums, index + 1, dp);
        return dp[index] = Math.min(leaveNext, pickNext);
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = words[i];
            if (str.contains(String.valueOf(x))) {
                result.add(i);
            }
        }
        return result;
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] nums2 = new int[n][2];
        int[] result = new int[n];
        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums2[i][0] = nums[i];
            nums2[i][1] = i;
        }
        Arrays.sort(nums2, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums2[i][0] - nums2[i - 1][0] > limit) {
                indices.add(new ArrayList<>());
            }
            indices.get(indices.size() - 1).add(nums2[i][1]);
        }
        for (List<Integer> index : indices) {
            List<Integer> sortedIndex = new ArrayList<>(index);
            Collections.sort(sortedIndex);
            for (int j = 0; j < index.size(); j++) {
                result[sortedIndex.get(j)] = nums[index.get(j)];
            }
        }
        return result;
    }

    public static boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < k; j++) {
                    shiftLeft(mat, i);
                }
            } else {
                for (int j = 0; j < k; j++) {
                    shifright(mat, i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] != mat[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void shiftLeft(int[][] mat, int row) {
        int first = mat[row][0];
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 1; i < m; i++) {
            mat[row][i - 1] = mat[row][i];
        }
        mat[row][m - 1] = first;
    }

    private static void shifright(int[][] mat, int row) {
        int n = mat.length;
        int m = mat[0].length;
        int last = mat[row][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mat[row][i + 1] = mat[row][i];
        }
        mat[row][0] = last;
    }

    public static int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int countv = 0;
        int countc = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (isVowel(ch)) {
                    countv++;
                } else {
                    countc++;
                }
                if (countv == countc && (countv * countc) % k == 0) {
                    result++;
                }
            }
            countc = 0;
            countv = 0;
        }
        return result;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(tmap);
        int result = Integer.MAX_VALUE;
        int first = 0;
        int last = 0;
        while (last < n - 1) {
            char ch = s.charAt(last);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            while (compare(sMap, tmap)) {
                char temp = s.charAt(first);
                if (sMap.containsKey(temp)) {
                    sMap.put(temp, sMap.get(temp) - 1);
                    if (sMap.get(temp) == 0) {
                        sMap.remove(temp);
                    }
                }
            }
            result = Math.min(last - first + 1, result);
            last++;
        }

        String resultv = "";
        for (int i = first; i < last; i++) {
            resultv += s.charAt(i);
        }
        return resultv;
    }

    private static boolean compare(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        boolean result = false;
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (smap.containsKey(key) && smap.get(key) != val) {
                return false;
            }
        }
        return true;
    }

    public static long minimumSteps(String s) {
        int n = s.length();
        char[] nums = s.toCharArray();
        int result = 0;
        int zero = n - 1;
        int one = n - 1;
        while (zero >= 0 && one >= 0) {
            while (zero >= 0 && nums[zero] != '0') {
                zero--;
            }
            System.out.println("<<>>" + zero);
            one = zero - 1;
            while (one >= 0 && nums[one] != '1') {
                one--;
            }

            if (zero >= 0)
                nums[zero] = '1';
            if (one >= 0)
                nums[one] = '0';
            if (one >= 0 && zero >= 0)
                result += (zero - one);
            //System.out.println(zero+"<<>>"+one);
            zero--;
        }
        return result;
    }
}
