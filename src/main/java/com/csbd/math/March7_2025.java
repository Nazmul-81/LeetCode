package com.csbd.math;

import java.util.ArrayList;
import java.util.List;

public class March7_2025 {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i * i <= right; i++) {
            if (!primes[i]) {
                for (int j = 2; j * i <= right; j++) {
                    primes[j * i] = true;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        List<Integer> primList = new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(!primes[i]){
                primList.add(i);
            }
        }

        if(primList.size() < 2){
            return ans;
        }
        int diff  = Integer.MAX_VALUE;
        for(int i=0; i< primList.size() - 1; i++ ){
            int d = primList.get(i + 1) - primList.get(i);
            if(d < diff){
                diff = d;
                ans[0] = primList.get(i);
                ans[1] = primList.get(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new March7_2025().closestPrimes(10, 19));
    }
}
