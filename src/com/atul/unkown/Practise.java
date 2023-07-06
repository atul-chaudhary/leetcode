package com.atul.unkown;

import java.util.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practise {
    public static void main(String[] args) {
        int[] nums = {11, 22, 33, 44, 55};
        //System.out.println(sumBetweenTwoKth(nums, 7, 3, 6));
        System.out.println(binarysearch(nums, nums.length, 44));
    }



    static int finalAns = Integer.MIN_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] kids = new int[k];
        solve(0, kids, cookies);
        return finalAns;
    }

    private static void solve(int index, int[] kids, int[] cook) {
        if (index == cook.length) {
            int max = Integer.MIN_VALUE;
            for (int it : kids) {
                max = Math.max(max, it);
            }
            finalAns = Math.max(finalAns, max);
            return;
        }

        for (int i = 0; i < kids.length; i++) {
            kids[i] += cook[index];
            solve(index + 1, kids, cook);
            kids[i] -= cook[index];
        }
    }

    static class PairT {
        int j;
        double prob;

        public PairT(int j, double prob) {
            this.j = j;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<PairT>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            double prob = succProb[i];

            adj.get(x).add(new PairT(y, prob));
            adj.get(y).add(new PairT(x, prob));
        }

        boolean[] vis = new boolean[n];

        Queue<PairT> pq = new PriorityQueue<>((a, b) -> (int) (b.prob - a.prob));
        pq.offer(new PairT(start, 1));

        double result = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            PairT node = pq.poll();
            if (node.j == end) result = Math.max(result, node.prob);
            vis[node.j] = true;
            for (PairT it : adj.get(node.j)) {
                if (vis[it.j] == false) {
                    pq.offer(new PairT(it.j, node.prob * it.prob));
                }
            }
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }

    static int binarysearch(int arr[], int n, int k) {
        // code here
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (long it : A) {
            pq.offer(it);

            if (pq.size() > K2) {
                pq.poll();
            }
        }
        System.out.println(pq);

        long k2 = pq.peek();
        long cur = K2;
        while (!pq.isEmpty() && cur > K1) {
            pq.poll();
            cur--;
        }

        //System.out.println(k2);
        long k1 = pq.peek();
        //System.out.println(k1);
        long sum = 0;
        for (long it : A) {
            if (it > k1 && it < k2) {
                sum += it;
            }
        }
        return sum;
    }


    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] result = new int[k];
        int index = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                result[index++] = pq.poll().val;
            }
        }
//        int[] result = new int[k];
//        int index = 0;
//        while (k > 0) {
//            result[index++] = pq.poll().val;
//            k--;
//        }
        return result;
    }


    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        // your code here
        Queue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int it : arr) {
            pq.offer(it);

            if (pq.size() > k) {
                result.add(pq.poll());
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        int[] temp = Arrays.copyOf(arr, arr.length);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(arr[i], set);
            } else {
                map.get(arr[i]).add(i);
            }
        }
        Arrays.sort(temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(map);
        for (int i = 0; i < n; i++) {
            if (temp[i] == arr[i]) continue;
            int item = arr[i];
            Set<Integer> set = map.get(item);
            System.out.println(i + "<<>>" + k);
            if (!set.contains(i + k)) {
                return "No";
            }
        }
        return "Yes";
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        // code here
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : arr) {
            pq.offer(it);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static int kthSmallestopt(int[] arr, int l, int r, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : arr) {
            pq.offer(it);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : arr) {
            pq.offer(it);
        }
        int result = -1;
        while (k > 0) {
            result = pq.poll();
            k--;
        }
        return result;
    }
}
