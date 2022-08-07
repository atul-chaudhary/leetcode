package com.atul.contest;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,1};
        System.out.println(taskSchedulerIII(arr, 3));
    }

    public static long taskSchedulerIII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 0;

        for (int item : tasks) {
            if (map.containsKey(item) && map.get(item) > day)
                day = map.get(item);

            day++;
            map.put(item, day + space);
        }

        return day;
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
