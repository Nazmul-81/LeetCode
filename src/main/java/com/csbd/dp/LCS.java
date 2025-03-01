package com.csbd.dp;

import java.util.Arrays;

public class LCS {
    // 1143. Longest Common Subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        return lcs(memo, text1, text2, 0, 0);
    }

    private int lcs(int[][] memo, String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length())
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = 1 + lcs(memo, s1, s2, i + 1, j + 1);
        } else {
            return memo[i][j] = Math.max(lcs(memo, s1, s2, i + 1, j), lcs(memo, s1, s2, i, j + 1));
        }
    }
}
