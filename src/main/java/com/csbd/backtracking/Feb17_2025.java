package com.csbd.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Feb17_2025 {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int ans = 0;
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        tiles = new String(charArray);
        Set<String> permutations = new HashSet<>();
        for (int mask = 1; mask < (1 << n); mask++) {
            int[] counter = new int[26];
            int totalCount = 0;
            StringBuilder permutation = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    counter[tiles.charAt(i) - 'A']++;
                    totalCount++;
                    permutation.append(tiles.charAt(i));
                }
            }

            if (permutations.contains(permutation.toString()))
                continue;

            permutations.add(permutation.toString());

            long subAns = factorial(totalCount);

            for (int i = 0; i < 26; i++) {
                if (counter[i] > 0) {
                    subAns /= factorial(counter[i]);
                }
            }

            ans += subAns;
        }

        return ans;
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
