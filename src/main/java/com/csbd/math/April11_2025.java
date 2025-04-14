package com.csbd.math;

public class April11_2025 {
    public int countSymmetricIntegers(int low, int high) {
        int counter = 0;
        for(int num = low; num < high; num ++){
            if(isSymmetric(num))
                counter ++;
        }
        return counter;
    }

    private boolean isSymmetric(int n){
        String numString = String.valueOf(n);
        if(numString.length() % 2 != 0)
            return false;

        int sum =0;
        for(int i=0; i<numString.length(); i++){
            if(i < numString.length() / 2)
                sum += numString.charAt(i) - '0';
            else
                sum -= numString.charAt(i) - '0';
        }

        return sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(new April11_2025().countSymmetricIntegers(1200, 1230));
    }

}
