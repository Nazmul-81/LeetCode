package com.csbd.dp;

public class Feb28_2025 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        StringBuilder superSequence = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                superSequence.append(str1.charAt(i-1));
                i --;
                j --;
            }
            else if(dp[i-1][j] < dp[i][j-1]){
                superSequence.append(str1.charAt(i-1));
                i--;
            }else{
                superSequence.append(str2.charAt(j-1));
                j--;
            }
        }

        while (i > 0){
            superSequence.append(str1.charAt(i-1));
            i--;
        }

        while (j > 0){
            superSequence.append(str2.charAt(j-1));
            j--;
        }

        return superSequence.reverse().toString();




    }
}
