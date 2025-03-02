package com.csbd.array;

import java.util.Map;
import java.util.TreeMap;

public class March2_25 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] n : nums1) {
            map.put(n[0], n[1]);
        }

        for (int[] n : nums2) {
            map.put(n[0], n[1] + map.getOrDefault(n[0], 0));
        }

        int[][] ans = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return ans;
    }
}
