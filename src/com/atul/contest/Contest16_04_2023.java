package com.atul.contest;

import java.util.*;

public class Contest16_04_2023 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "pqr";
        System.out.println(mergeAlternately(a, b));
    }

    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        String str = "";
        int index = 0;
        while (index < n || index < m) {
            if (index < n) {
                str += word1.charAt(index);
            }
            if (index < m) {
                str += word2.charAt(index);
            }
            index++;
        }
        return str;
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length;
        int m = word2.length;
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < n; i++) {
            str1 += word1[i];
        }

        for (int i = 0; i < m; i++) {
            str2 += word2[i];
        }
        return str1.equals(str2);
    }


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = candies[i] + extraCandies;
            if (num >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }


    public static int addMinimumOpt(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int as = map.getOrDefault('a', 0);
        int bs = map.getOrDefault('b', 0);
        int cs = map.getOrDefault('c', 0);
        int max = Math.max(as, Math.max(bs, cs));
        int num = 0;
        num += max - as;
        num += max - bs;
        num += max - cs;
        return num;
    }

    public static int addMinimum(String word) {
        int i = 0;
        int ans = 0;
        while (i < word.length()) {
            if (i < word.length() && word.charAt(i) == 'a') {
                i++;
            } else {
                ans++;
            }
            if (i < word.length() && word.charAt(i) == 'b') {
                i++;
            } else {
                ans++;
            }
            if (i < word.length() && word.charAt(i) == 'c') {
                i++;
            } else {
                ans++;
            }

        }
        return ans;
    }

    static class Pair {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<List<Integer>> adj = new ArrayList<>();
        int priceSum = 0;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            int num = price[i] / 2;
            priceSum += num;
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int cur = price[i] / 2;
            int curSum = priceSum - cur;
            int total = curSum + price[i];
            if (total < min) {
                min = total;
                index = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != index) {
                price[i] = price[i] / 2;
            }
        }
        System.out.println("<<>>" + Arrays.toString(price));
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int k = trips.length;
        int price_sum = 0;
        for (int i = 0; i < k; i++) {
            int u = trips[i][0];
            int v = trips[i][1];
            int[] dist = solve(adj, n, u, price);
            System.out.println("dist " + Arrays.toString(dist));
            price_sum += dist[v];
        }
        return price_sum;
    }

    private static int[] solve(List<List<Integer>> adj, int n, int src, int[] price) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[src] = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(src, price[src]));
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.v;
            int wt = temp.wt;
            for (int it : adj.get(node)) {
                int newWt = price[it] + wt;
                if (newWt < dist[it]) {
                    dist[it] = newWt;
                    pq.offer(new Pair(it, newWt));
                }
            }
        }
        return dist;
    }

    public static int maxDivScore(int[] nums, int[] divisors) {
        int n = nums.length;
        int m = divisors.length;
        int max = Integer.MIN_VALUE;
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] % divisors[i] == 0) {
                    cur++;
                }
            }
            //System.out.println(cur + "<<>>");
            if (cur > max) {
                max = cur;
                num = divisors[i];
            } else if (cur == max) {
                num = Math.min(num, divisors[i]);
            }
        }
        return num;
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    curr++;
                }
            }
            if (curr > max) {
                max = curr;
                row = i;
            }
        }
        return new int[]{row, max};
    }
}
