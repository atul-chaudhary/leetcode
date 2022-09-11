package com.atul.contest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static void main(String[] args) {
        int[][] arr = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroupsOpt(arr));
     }

    public static int minGroupsOpt(int[][] intervals) {
        Arrays.sort(intervals,	 (o1,o2)->(o1[0]==o2[0])?o2[1]-o1[1]:o1[0]-o2[0]);
        Queue<Integer> quee = new PriorityQueue<Integer>();
        int maxresult = 0;
        int result = 0;
        for(int i = 0;i<intervals.length;i++)
        {
            while(!quee.isEmpty()&& quee.peek()< intervals[i][0])
            {
                quee.poll();
                maxresult--;
            }
            quee.add(intervals[i][1]);
            System.out.println(quee);
            maxresult++;
            result = Math.max(maxresult, result);
        }

        return result;
    }

    public static int minGroups(int[][] arr) {
        Arrays.sort(arr,(a, b)->a[0]-b[0]);
        for(int[] row : arr) System.out.println(Arrays.toString(row));
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>(Arrays.asList(arr));
        int count = 0;
        while(!arrayDeque.isEmpty()){
            int[] first = arrayDeque.getFirst();
            while(true){
                if(!(arrayDeque.getLast()[0] > first[1])){
                    break;
                }else{
                    arrayDeque.pollLast();
                }
            }
            arrayDeque.pollFirst();
            count++;
        }
        return count;
    }
}
