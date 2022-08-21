package com.atul.dynamic_programming;

import javax.xml.stream.events.StartDocument;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNumberRefuelingStops {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        map.put(4,2);
        map.put(5,2);
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getKey() == 2){
//                map.remove(entry.getValue());
//            }
//        }

        int[][] stations = {{25,25},{50,50},};
        int target = 100;
        int startFuel = 50;
        System.out.println(minRefuelStops(target, startFuel, stations));
    }

//    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
//        if(target == startFuel) return 0;
//        if(stations.length >= 1 && startFuel < stations[0][1]) return -1;
//        return solve(stations, 0, target, startFuel, stations.length);
//    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0, count = 0, far = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(far < target){
            while(i < stations.length && stations[i][0] <= far){
                pq.offer(stations[i][1]);
                i++;
            }
            if(pq.size() == 0){
                return -1;
            }
            System.out.println(pq);
            far += pq.poll();
            count++;
        }
        return count;
    }

    private static int solve(int[][] arr, int index, int target, int curFuel, int n) {
        if (target == curFuel) return 1;
        if (index == n) {
            if(target != 0) return -1;
            return 0;
        }

        int pick = 0;
        if(curFuel >= arr[index][0]){
            pick = 1 + solve(arr, index + 1, target - arr[index][0], curFuel - arr[index][0] + arr[index][1] , n);
        }
        int notpick = solve(arr, index +1, target - arr[index][0], curFuel - arr[index][0], n);

        return Math.min(pick, notpick);
    }
}
