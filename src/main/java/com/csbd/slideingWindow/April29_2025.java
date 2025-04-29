package com.csbd.slideingWindow;

public class April29_2025 {
    // 2962. Count Subarrays Where Max Element Appears at Least K Time

    public long countSubarrays(int[] nums, int k) {
        int maxVal = 0;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }

        int maxvalueCounter = 0;
        int j = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                // reduce window
                if (nums[i - 1] == maxVal) {
                    maxvalueCounter--;
                }
            }

            // expanding window
            while (j < nums.length && maxvalueCounter < k) {
                if (nums[j] == maxVal) {
                    maxvalueCounter++;
                }
                j++;
            }

            if(maxvalueCounter >= k){
                res += (nums.length - j + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        System.out.println(new April29_2025().countSubarrays(nums, 2));
    }
}
