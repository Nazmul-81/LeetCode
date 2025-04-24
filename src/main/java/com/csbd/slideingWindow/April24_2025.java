package com.csbd.slideingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class April24_2025 {
    public int countCompleteSubarrays(int[] nums) {
        int uniqueCount = getNumberOfUniqueNum(nums);
        HashMap<Integer, Integer> mapOfNumberToCount = new HashMap<>();

        int r = 0;
        int ans = 0;

        for (int l = 0; l < nums.length; l++) {
            if (l > 0) {
                Integer prevCount = mapOfNumberToCount.get(nums[l - 1]);
                if (prevCount == 1) {
                    mapOfNumberToCount.remove(nums[l - 1]);
                } else {
                    mapOfNumberToCount.put(nums[l-1], prevCount - 1);
                }
            }

            Integer prevCount = mapOfNumberToCount.getOrDefault(nums[l], 0);
            mapOfNumberToCount.put(nums[l], prevCount + 1);

            while (r < nums.length && mapOfNumberToCount.size() < uniqueCount){
                Integer prev = mapOfNumberToCount.getOrDefault(nums[r], 0);
                mapOfNumberToCount.put(nums[r], prev + 1);
                r++;
            }

            if(mapOfNumberToCount.size() == uniqueCount){
                ans = ans + (nums.length - r + 1);
            }

        }
        return ans;
    }

    private int getNumberOfUniqueNum(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int n : nums) {
            numberSet.add(n);
        }
        return numberSet.size();
    }
}
