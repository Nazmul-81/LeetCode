package com.csbd.hashTable;

public class April20_2025 {

    public int numRabbits(int[] answers) {
        int[] counter = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            counter[answers[i]]++;
        }

        int ans = 0;
        for (int i = 0; i < counter.length; i++) {
            ans += (int) (Math.ceil((double) counter[i] / (i + 1)) * (i + 1));
        }

        return ans;
    }
}
