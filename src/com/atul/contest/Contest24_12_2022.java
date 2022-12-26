package com.atul.contest;

import java.util.*;

public class Contest24_12_2022 {
    public static void main(String[] args) {
        int[] f = {-1,-1,0,1,0,0,1,-1,1,0};//{-1,-1,1,-1,-1,0};//{1,-1,-1,1,1};//{0,0,1,-1};//{1, 0, 0, -1, 0, 0, 0, 0, 1};
        System.out.println(captureForts(f));
    }

    static class Pair {
        int studentId;
        int points;

        public Pair(int studentId, int points) {
            this.studentId = studentId;
            this.points = points;
        }
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> post = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> neg = new HashSet<>(Arrays.asList(negative_feedback));

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.points == b.points ? a.studentId - b.studentId : b.points - a.points);
        int n = student_id.length;
        for (int i = 0; i < n; i++) {
            String[] str = report[i].split(" ");
            int size = str.length;
            int point = 0;
            int studentId = student_id[i];
            for (int j = 0; j < size; j++) {
                if (post.contains(str[j])) point += 3;
                if (neg.contains(str[j])) point -= 1;
            }
            pq.offer(new Pair(studentId, point));
        }

        List<Integer> result = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            result.add(pq.poll().studentId);
            k--;
        }
        return result;
    }

    public static int captureForts(int[] forts) {
        int n = forts.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if(forts[i] == 1){
                int index = i+1;
                int count = 0;
                while (index < n) {
                    if (forts[index] == 0) {
                        count++;
                    } else if (forts[index] == -1) {
                        result = Math.max(result, count);
                        break;
                    }else break;
                    index++;
                }
            }
        }
        System.out.println(result);
        for (int i = n-1; i >= 0; i--) {
            if(forts[i] == 1){
                int index = i-1;
                int count = 0;
                while (index >= 0) {
                    if (forts[index] == 0) {
                        count++;
                    } else if (forts[index] == -1) {
                        result = Math.max(result, count);
                        break;
                    }else break;
                    index--;
                }
            }
        }
        System.out.println(result);
        return result;
    }

}
