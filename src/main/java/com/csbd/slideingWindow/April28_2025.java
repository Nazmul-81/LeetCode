package com.csbd.slideingWindow;

public class April28_2025 {
    // 2302. Count Subarrays With Score Less Than K
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int l = 0;
        long total = 0;
        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            while (l <= r && total * (r - l + 1) >= k) {
                total -= nums[l];
                l++;
            }

            res += (r - l) + 1;
        }

        return res;
    }

}
