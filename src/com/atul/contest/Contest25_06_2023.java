package com.atul.contest;

import java.util.*;
import java.util.stream.Stream;

public class Contest25_06_2023 {
    public static void main(String[] args) {
        int[] post = {3, 5, 2, 6};
        int[] health = {10, 10, 15, 12};
        String dir = "RL";
        String str = Stream.of(dir.split("")).reduce("", (a, b) -> b + a);
        System.out.println(str);
        //System.out.println(survivedRobotsHealths(post, health, dir));
    }

    static class Tuple {
        int index;
        int post;
        int health;
        char dir;

        public Tuple(int index, int post, int health, char dir) {
            this.index = index;
            this.post = post;
            this.health = health;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "index=" + index +
                    ", post=" + post +
                    ", health=" + health +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Tuple> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Tuple(i, positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(list, (a, b) -> a.post == b.post ? a.index - b.index : a.post - b.post);
        Stack<Tuple> stack = new Stack<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            boolean flag = true;
            Tuple cur = list.get(i);
            if (cur.dir == 'R') {
                stack.push(cur);
            } else {
                int health = -1;
                while (!stack.empty() && health != 0) {
                    if (stack.peek().health == cur.health) {
                        stack.pop();
                        health = 0;
                        //break;
                    } else if (stack.peek().health > cur.health) {
                        Tuple t = stack.pop();
                        t.health--;
                        stack.push(t);
                        health = 0;
                        //break;
                    } else {
                        stack.pop();
                        Tuple t = list.get(i);
                        t.health--;
                        cur = t;
                    }
                }
                if (health != 0) {
                    stack.push(cur);
                }
            }
        }

        List<Tuple> remaining = new ArrayList<>();
        while (!stack.isEmpty()) {
            remaining.add(stack.pop());
        }
        Collections.sort(remaining, (a, b) -> a.index - b.index);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < remaining.size(); i++) {
            ans.add(remaining.get(i).health);
        }
        return ans;
    }

    public static int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int noOfZeros = 0;
        long ans = 0;
        int noOfOne = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                noOfZeros++;
            } else {
                noOfOne++;
                if (noOfOne == 1) {
                    ans = 1;
                } else {
                    ans = (ans * (noOfZeros + 1) % mod) % mod;
                }
                noOfZeros = 0;
            }
        }
        return (int) ans;
    }

    public static int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int first = Integer.parseInt(String.valueOf(String.valueOf(nums[i]).charAt(0)));
                String str = String.valueOf(nums[j]);
                int last = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
                int gcd = gcd(first, last);
                if (gcd == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
}
