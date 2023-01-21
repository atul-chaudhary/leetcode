package com.atul.arrays;

import java.util.Arrays;

public class ExamRoomQuestion {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));
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
        int[] nums = null;
        int count = 0;
        int n;

        public ExamRoom(int n) {
            nums = new int[n];
            this.n = n;
        }

        public int seat() {
            return 0;
        }

        public void leave(int p) {
            nums[p] = 0;
            count--;
        }
    }

}
