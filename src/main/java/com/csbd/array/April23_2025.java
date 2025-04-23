package com.csbd.array;

public class April23_2025 {
    public int countLargestGroup(int n) {
        int[] counter = new int[50];
        int mx = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int ds = digitSum(i);
            counter[ds]++;
            mx = Math.max(counter[ds], mx);
        }

        int ans = 0;
        for(int i=0; i<counter.length; i++){
            if(counter[i] == mx){
                ans ++;
            }
        }
        return ans;
    }

    private int digitSum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new April23_2025().countLargestGroup(13));
    }
}
