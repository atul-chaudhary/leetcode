package com.atul.contest;

public class ShiftingLettersII {
    public static void main(String[] args) {
        String s = "dztz";
        System.out.println(new StringBuilder(s).replace(0, 1, "z"));
        int[][] dp = {{0,0, 0}, {1, 1, 1}};
        System.out.println(shiftingLetters(s, dp));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        for (int[] row : shifts) {
            int start = row[0];
            int end = row[1];
            int dir = row[2];
            s = solve(start, end, dir, s);
        }
        return s;
    }

    private static String solve(int start, int end, int dir, String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = start; i <= end; i++) {
            int cur = sb.charAt(i) - 'a';
            if (dir == 1) {
                if (cur == 25) {
                    sb.replace(i, i + 1, "a");
                } else {
                    cur = cur +1 + 'a';
                    sb.replace(i, i + 1, String.valueOf((char) cur));
                }
            } else {
                if (cur == 0) {
                    sb.replace(i, i + 1, "z");
                } else {
                    cur = cur -1 + 'a';
                    sb.replace(i, i + 1, String.valueOf((char) cur));
                }
            }
        }
        return sb.toString();
    }

}
