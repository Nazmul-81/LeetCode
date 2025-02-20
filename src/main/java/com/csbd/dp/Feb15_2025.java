package com.csbd.dp;

public class Feb15_2025 {
    public int punishmentNumber(int n) {
        return 0;
    }

    private boolean findPartition(int startIndex, int sum, String numStr, int target, int[][] memo) {
        if (startIndex == numStr.length()) {
            return sum == target;
        }

        if (sum > target) {
            return false;
        }

        if (memo[startIndex][sum] != -1) return memo[startIndex][sum] == 1;

        for (int i = startIndex; i < numStr.length(); i++) {
            boolean partitionFound =  false;

        }
        return false;

    }
}
