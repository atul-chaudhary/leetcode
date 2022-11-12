package com.atul.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] arr = {{-2147483646,-2147483645},{2147483646,2147483647}};//{{10,16},{2,8},{1,6},{7,12}};//{{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}};
        System.out.println(findMinArrowShotsopt(arr));
        System.out.println(findMinArrowShots2(arr));

    }

    public static int findMinArrowShotsopt(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums, (a, b)-> a[1]-b[1]);
        for(int[] row : nums) System.out.println(Arrays.toString(row));
        int arrow = 1;
        long endPoint = nums[0][1];
        for(int i=1;i<n;i++){
            long num = nums[i][0];
            if(num > endPoint){
                arrow++;
                endPoint = nums[i][1];
            }
        }
        return arrow;
    }

    public static int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));
        for(int[] row : points) System.out.println(Arrays.toString(row));
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }

    public static int findMinArrowShots(int[][] nums) {
        Arrays.sort(nums, (a, b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        for(int[] row : nums) System.out.println(Arrays.toString(row));
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0][1]);
        int count = 1;
        for (int i = 1; i < n; i++) {
            int num = pq.peek();
            if(nums[i][0] >= num){
                pq.poll();
                pq.add(nums[i][1]);
            }else{
                count++;
                pq.add(nums[i][1]);
            }
        }
        return count;
    }
}
