package com.csbd.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Feb7_2025 {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];

        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];

            Integer previousColor = colorMap.get(index);
            if (previousColor != null) {
                colorCount.put(previousColor, colorCount.get(previousColor) - 1);

                if (colorCount.get(previousColor) == 0) {
                    colorCount.remove(previousColor);
                }
            }

            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            colorMap.put(index, color);
            ans[i] = colorCount.size();
        }

        return ans;

    }
}
