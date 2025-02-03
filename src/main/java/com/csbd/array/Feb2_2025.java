package com.csbd.array;

public class Feb2_2025 {
    //3105. Longest Strictly Increasing or Strictly Decreasing Subarray


    public int longestMonotonicSubarray(int[] nums) {

        int mxInc = 1;
        int mxDec = 1;

        int inc = 1;
        int dec = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                mxInc = Math.max(mxInc, inc);
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                mxDec = Math.max(mxDec, dec);
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
        }

        return Math.max(mxDec, mxInc);

    }
}
