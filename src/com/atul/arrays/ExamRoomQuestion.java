package com.atul.arrays;

import java.util.Arrays;
import java.util.TreeSet;

public class ExamRoomQuestion {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());
    }

    static class ExamRoom {
        TreeSet<Integer> set = new TreeSet<>();
        int n;

        public ExamRoom(int n) {
            this.n = n;
        }

        public int seat() {
            if(set.isEmpty()){
                set.add(0);
                return 0;
            }
            int mid = 0;
            int index = 0;
            int left = set.first();
            int diff = left;
            for(int right: set){
                if(left == right) continue;
                mid = (left+right)/2;
                if(diff < Math.min(mid-left, right-mid) && !set.contains(mid)){
                    diff = Math.min(mid-left, right-mid);
                    index = mid;
                }
            }

            int last = set.last();
            if(n-last > diff) index = n;
            return index;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

}
