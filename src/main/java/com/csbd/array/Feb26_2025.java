package com.csbd.array;

public class Feb26_2025 {
    public int maxAbsoluteSum(int[] nums) {
        // 1749. Maximum Absolute Sum of Any Subarray

        // finding the maxValue using Kadane's algorithm
        int maxValue = Integer.MIN_VALUE;
        int localMax = 0;

        for (int n : nums) {
            localMax += n;
            if (localMax > maxValue) {
                maxValue = localMax;
            }
            if (localMax < 0) {
                localMax = 0;
            }
        }

        // find the minValue using kadane's algorithm
        int minValue = Integer.MAX_VALUE;
        int localMin = 0;

        for (int n : nums) {
            localMin += n;
            if (localMin < minValue) {
                minValue = localMin;
            }
            if (localMin > 0) {
                localMin = 0;
            }
        }

        return Math.max(maxValue , Math.abs(minValue));
    }
}
