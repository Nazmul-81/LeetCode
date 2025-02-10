package com.csbd.hashTable;

import java.util.HashMap;
import java.util.Map;

public class Feb9_2025 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> mapOfGoodPairsCounter = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int reducedNum = num - i;

            int count = mapOfGoodPairsCounter.getOrDefault(reducedNum, 0);

            ans += i - count;

            mapOfGoodPairsCounter.put(reducedNum, count + 1); // works like 1+2+3...
        }

        return ans;
    }
}
