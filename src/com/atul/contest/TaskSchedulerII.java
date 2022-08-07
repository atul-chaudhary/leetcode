package com.atul.contest;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,1};
        System.out.println(taskSchedulerII(arr, 3));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        long day = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i]) && (map.get(tasks[i]) - i -1) < space) {
                int n= space - (i - map.get(tasks[i]) - 1);
                System.out.println(n+ "<<<>>"+day);
                day+=n+1;
                map.put(tasks[i], i);
            }else{
                day++;
                map.put(tasks[i], i);
            }
            System.out.println(day+ " OUT");
        }
        return day;
    }
}
