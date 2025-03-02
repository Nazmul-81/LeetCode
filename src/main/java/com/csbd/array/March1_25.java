package com.csbd.array;

public class March1_25 {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int index = 0;
        for (int n : nums) {
            if (n == 0)
                continue;
            ans[index++] = n;
        }
        return ans;
    }
}
