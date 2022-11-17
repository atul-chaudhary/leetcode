package com.atul.greedy;

import java.util.*;

public class ActivitySelectionProblem {
    public static void main(String[] args) {

    }

    /*

Given a set of activities, along with the starting and finishing time of each activity, find the maximum number of activities performed by a single person assuming that a person can only work on a single activity at a time.

Input : [(1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11), (8, 12), (2, 13), (12, 14)]
Output: {(1, 4), (5, 7), (8, 11), (12, 14)}

Input : [(3, 7), (1, 3), (2, 9), (2, 7), (1, 2), (7, 8)]
Output: {(1, 3), (3, 7), (7, 8)} or {(1, 2), (3, 7), (7, 8)} or {(1, 2), (2, 7), (7, 8)}

*/
    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

}
