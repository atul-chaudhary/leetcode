package com.atul.contest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;

import static java.time.temporal.ChronoField.YEAR;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

public class EqualRowColumnPairs {

    public static void main(String[] args) {
//        int[][] arr = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
//        System.out.println(equalPairs(arr));

        DateTimeFormatter strangeFormat = new DateTimeFormatterBuilder()
                .appendValue(MONTH_OF_YEAR)
                .appendLiteral("/")
                .appendValue(DAY_OF_MONTH)
                .appendLiteral("/")
                .appendValue(YEAR).toFormatter();

        LocalDate localDate3 = LocalDate.parse("09/2 /2021", strangeFormat);
        System.out.println(localDate3);
    }

    public static int equalPairs(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count= 0;
        /*for(int i=0;i<n;i++){
            String row="";
            for(int j=0;j<n;j++){
                row+=arr[i][j]+ " ";
            }
            System.out.println("row "+row);
            for(int j=0;j<m;j++){
                String col = "";
                for(int k=0;k<n;k++){
                    col+=arr[k][j]+ " ";
                }
                System.out.println("col "+ col);
                if(row.equals(col)) count++;
            }
        }*/
        ArrayList<String> rows = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                row += arr[i][j] + " ";
            }
            rows.add(row);
        }
        ArrayList<String> cols = new ArrayList<>();
        for(int j=0;j<m;j++){
            String col = "";
            for(int k=0;k<n;k++){
                col+=arr[k][j]+ " ";
            }
            cols.add(col);
        }
        for(int i=0;i<rows.size();i++){
            for (int j = 0; j < cols.size(); j++) {
                if(rows.get(i).equals(cols.get(j))) count++;
            }
        }
        return count;
    }

}
