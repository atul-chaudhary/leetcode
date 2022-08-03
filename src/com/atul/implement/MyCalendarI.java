package com.atul.implement;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class MyCalendarI {
    public static void main(String[] args) {
        System.out.println(book(10, 20));
        System.out.println(set);
        System.out.println(book(20, 30));
        System.out.println(set);
    }

    static class Pair{
        Integer start;
        Integer end;
    }

    static HashSet<String> set = new HashSet<>();
    public static boolean book(int start, int end) {
        for (String s : set) {
            String[] sp = s.split("-");
            int st = Integer.parseInt(sp[0]);
            int en = Integer.parseInt(sp[1]);
            if (start < en && st < end) {
                return false;
            }
        }
        set.add(start+ "-"+end);
        return true;
    }
}
