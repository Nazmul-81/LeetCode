package com.csbd.array;

public class Feb3_25 {
    // 1800. Maximum Ascending Subarray Sum
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];

        int currentSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                currentSum += nums[i];
                ans = Math.max(ans, currentSum);
            }else{
                currentSum = nums[i];
            }
        }
        return ans;
    }

}
