package com.csbd.array;

public class April30_2025 {
    // 1295. Find Numbers with Even Number of Digits
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int n: nums){
            if(getDigitCount(n) % 2 == 0)
                res ++;
        }
        return res;
    }

    private int getDigitCount(int n){
        int count = 0;
        while(n > 0){
            count++;
            n /= 10;
        }
        return count;
    }
}
