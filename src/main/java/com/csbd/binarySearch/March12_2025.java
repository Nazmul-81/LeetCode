package com.csbd.binarySearch;

public class March12_2025 {
    public int maximumCount(int[] nums) {
        int p = nums.length - upperBound(nums, 0);
        int n = lowerBound(nums, 0);
        return Math.max(p, n);
    }

    private int lowerBound(int[] nums, int n) {
        int index = nums.length;
        int r = nums.length - 1;
        int l = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] >= n) {
                index = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }

    private int upperBound(int[] nums, int n) {
        int index = nums.length;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] > n) {
                index = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }
}
