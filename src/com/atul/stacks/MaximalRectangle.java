package com.atul.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        List arrayList = Arrays.asList("as", "sasa");
        ArrayList arrayList1 = new ArrayList(Arrays.asList("xas", "ass"));
        int[][] mat = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };

        System.out.println(maximalRectangle(mat));
    }

    public static int maximalRectangle(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dp = new int[m];
        for(int i=0;i<m;i++){
            dp[i] = (int)mat[0][i];
        }
        int maxArea = largestRectangleArea(dp);
        System.out.println(maxArea);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                dp[j] = mat[i][j] != 0 ? (int) mat[i][j] + dp[j] : 0;
            }
            System.out.println(Arrays.toString(dp));
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }
        return maxArea;

    }

    public static int largestRectangleArea(int[] arr) {
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        //0 consist of val
        //1 consist of index
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) stack.pop();
            if(stack.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = stack.peek()[1];
            }
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = i;
            stack.push(temp);
        }
        stack.clear();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) stack.pop();
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek()[1];
            }
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = i;
            stack.push(temp);
        }

        //System.out.println(Arrays.toString(nsl));
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]*(nsr[i]-nsl[i]-1));
        }
        return max;
    }
}
