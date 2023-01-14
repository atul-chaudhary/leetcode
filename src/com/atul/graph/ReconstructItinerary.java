package com.atul.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
    public static void main(String[] args) {

    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int max = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if(k==i || k == j) continue;
                    int a = (points[j][1]-points[i][1]) * (points[k][1]- points[i][1]);
                    int b = (points[j][0]-points[i][0]) * (points[k][0]- points[i][0]);
                    if(a==b) count++;
                }
                max = Math.max(max, count+2);
            }
        }
        return max;
    }

}
