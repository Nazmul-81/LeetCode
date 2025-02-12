package com.csbd.hashTable;

import java.util.HashMap;
import java.util.Map;

public class Feb12_2025 {
    // 2342. Max Sum of a Pair With Equal Sum of Digits
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int n : nums) {
            int digitCount = digitSum(n);
            Integer previousNumber = map.get(digitCount);
            if (previousNumber != null) {
                ans = Math.max(ans, previousNumber + n);
                map.put(digitCount, Math.max(previousNumber, n)); // always keep the max value in the map
            } else {
                map.put(digitCount, n);
            }
        }
        return ans;
    }

    private int digitSum(int n) {
        int c = 0;
        while (n > 0) {
            c += n % 10;
            n /= 10;
        }
        return c;
    }
}
