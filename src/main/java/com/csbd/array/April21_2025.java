package com.csbd.array;

public class April21_2025 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // 2145. Count the Hidden Sequences
        long firstLineMax = lower;
        long left = lower;
        for(int i=0; i<differences.length; i++){
            left = left + differences[i];
            firstLineMax = Math.max(firstLineMax, left);
        }

        long lastLineMin = upper;
        left = upper;
        for(int i=0; i<differences.length; i++){
            left = left + differences[i];
            lastLineMin = Math.min(lastLineMin, left);
        }

        return Math.max(0,(int) (lastLineMin - firstLineMax + 1));
    }

    public static void main(String[] args) {
        int [] diff = {3,-4,5,1,-2};
        System.out.println(new April21_2025().numberOfArrays(diff, -4, 5));
    }
}
