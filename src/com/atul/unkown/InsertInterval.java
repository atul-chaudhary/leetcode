package com.atul.unkown;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 6};
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            int[][] tempResult = new int[1][2];
            tempResult[0] = newInterval;
            return tempResult;
        }
        int count = 0;
        int start = -1;
        int end = -1;
        int min = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ((newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) || (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) ||
                    (intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1]) || (intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1])
            ) {
                count++;
                if (start == -1) {
                    min = intervals[i][0];
                    start = i;
                }
                end = i;
                max = Math.max(max, intervals[i][1]);
            }
        }
        List<int[]> result = new ArrayList<>();
        if (count == 0) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (newInterval[0] < intervals[i][0] && flag) {
                    result.add(newInterval);
                    flag = false;
                }
                result.add(intervals[i]);
            }
            if (flag) {
                result.add(newInterval);
            }
        } else {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (i >= start && i <= end) {
                    if (flag) {
                        int ending = Math.max(max, newInterval[1]);
                        int starting = Math.min(min, newInterval[0]);
                        result.add(new int[]{starting, ending});
                        flag = false;
                    }
                } else {
                    result.add(intervals[i]);
                }
            }
        }
        int size = result.size();
        for (int[] row : result) System.out.println(Arrays.toString(row));
        int[][] finalResult = new int[size][2];
        for (int i = 0; i < size; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}
