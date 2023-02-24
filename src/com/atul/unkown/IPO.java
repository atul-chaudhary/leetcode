package com.atul.unkown;

import com.sun.deploy.panel.WinUpdatePanel;
import javafx.scene.chart.Axis;

import java.util.*;

public class IPO {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-2, 3, 1, -5);
        System.out.println(minX(nums));
    }

    public static int minX(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int result = 1;

        for (int i = n-1; i >= 0; i--) {
             result = result-arr.get(i);
             if(result < 1) result = 1;
        }
        return result;
    }


    public static List<Integer> meanderingArray(List<Integer> unsorted) {
        int n = unsorted.size();
        Collections.sort(unsorted);
        List<Integer> result = new ArrayList<>();
        System.out.println(unsorted);
        int left = 0;
        int right = n-1;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                result.add(unsorted.get(right));
                right--;
            }else {
                result.add(unsorted.get(left));
                left++;
            }
        }
        return result;
    }

    class Acquaintance{
        String name;

        public Acquaintance(String name) {
            this.name = name;
        }

        public void getStatus(){
            System.out.println(this.name + " is just an acquaintance.");
            System.out.println();
        }
    }

    class Friend extends Acquaintance {
        String homeTown;

        public Friend(String name, String homeTown) {
            super(name);
            this.homeTown = homeTown;
        }


        public void getStatus(){
            System.out.println(this.name + " is just a friend and he is from "+this.homeTown+".");
            System.out.println();
        }
    }

    class BestFriend extends Friend{
        String favoriteSong;

        public BestFriend(String name, String homeTown, String favoriteSong) {
            super(name, homeTown);
            this.favoriteSong = favoriteSong;
        }

        public void getStatus(){
            System.out.println(this.name + " is just my best friend. He is from "+this.homeTown+" and his favorite song is "+this.favoriteSong+".");
        }
    }

    static class Pair {
        int profit;
        int capital;

        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "p=" + profit + " c=" + capital;
        }
    }


    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = capital[i];
            nums[i][1] = profits[i];
        }


        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        while (k-- > 0){
            while (j < n && nums[j][0] <= w){
                pq.offer(nums[j][1]);
                j++;
            }
            if(pq.isEmpty()) break;
            w+= pq.poll();
        }
        return w;
    }

    public static int findMaximizedCapitalBruteForce(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit == a.profit ? a.capital - b.capital : b.profit - a.profit);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(profits[i], capital[i]));
        }
        System.out.println(pq);
        int ans = 0;
        while (!pq.isEmpty() && k > 0) {
            Pair node = pq.poll();
            if (node.capital <= w) {
                ans += node.profit;
                w += node.profit;
                k--;
            }
        }
        return ans;
    }
}
