package com.atul.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DesignBrowserHistory {
    public static void main(String[] args) {
        int[] nums = {50,
                90,
                23,
                44};

        System.out.println(minimizeDisparityBing(nums));
    }

    public static int max(int[] arr) {
        return arr[arr.length - 1]; // The last element is the maximum after sorting
    }

    // A helper method to find the minimum element in an array
    public static int min(int[] arr) {
        return arr[0]; // The first element is the minimum after sorting
    }

    // A method to minimize the disparity in an array
    public static int minimizeDisparityBing(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);

        // Initialize the output as the sum of disparities of the original array
        int output = 0;
        for (int i = 1; i < arr.length; i++) {
            output += max(Arrays.copyOfRange(arr, 0, i + 1)) - min(Arrays.copyOfRange(arr, 0, i + 1));
        }
        System.out.println("output "+output);

        // Try reversing the order of elements and update the output if it decreases
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i]; // Copy the elements in reverse order
        }
        System.out.println("trev"+Arrays.toString(reversed));
        // Calculate the new sum of disparities after reversing
        int newOutput = 0;
        for (int i = 1; i < reversed.length; i++) {
            newOutput += max(Arrays.copyOfRange(reversed, 0, i + 1)) - min(Arrays.copyOfRange(reversed, 0, i + 1));
        }

        // Update the output if it decreases
        if (newOutput < output) {
            output = newOutput;
        }

        // Return the output
        return output;
    }


    public static boolean mainDP(int[] args) {
        int[] arr = {50, 90, 23, 44};
        int n = arr.length;
        Arrays.sort(arr); // sort the array in ascending order

        int[] dp = new int[n]; // create a dp array
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i]; // calculate the prefix sum
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res += (dp[n - 1] - dp[i - 1]) - (n - i) * arr[i - 1]; // calculate the result
        }

        System.out.println(res); // output the result
        return false;
    }

    public static int minimizeDisparityOpt(int[] speeds) {
        Arrays.sort(speeds); // Sort the speeds in non-decreasing order
        int n = speeds.length;
        int minTotalDisparity = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int maxDisparity = speeds[i+1] - speeds[0];
            int minDisparity = speeds[n-1] - speeds[i+1];
            int totalDisparity = maxDisparity + minDisparity;
            minTotalDisparity = Math.min(minTotalDisparity, totalDisparity);
        }
        return minTotalDisparity;
    }

    public static int minimizeDisparity(int[] speeds) {
        Arrays.sort(speeds); // Sort the speeds in non-decreasing order
        int minDisparity = 0;
        for (int i = 0; i < speeds.length - 1; i++) {
            // Calculate the disparity for the first i+1 drivers
            int disparity = speeds[i + 1] - speeds[0];
            minDisparity += disparity;
        }
        return minDisparity;
    }


    static class BrowserHistory {
        Stack<String> stack;
        int curIndex = 0;

        public BrowserHistory(String homepage) {
            stack = new Stack<>();
            stack.push(homepage);
        }

        public void visit(String url) {
            if (curIndex < stack.size() - 1) {
                int times = stack.size() - curIndex - 1;
                while (times-- > 0) {
                    stack.pop();
                }
            }
            // System.out.println("cur steps vis"+curIndex);
            curIndex++;
            stack.push(url);
        }

        public String back(int steps) {
            if (curIndex - steps < 0) curIndex = 0;
            else
                curIndex -= steps;
            // System.out.println("cur steps back"+curIndex);
            return stack.elementAt(curIndex);
        }

        public String forward(int steps) {
            int dif = stack.size() - curIndex - 1;
            if (steps > dif)
                curIndex = stack.size() - 1;
            else
                curIndex += steps;

            //System.out.println("cur steps for"+curIndex);
            return stack.elementAt(curIndex);

        }
    }

}
