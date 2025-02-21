package com.csbd.array;

public class Feb20_2025 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();

        int len = (int) Math.pow(2, n);
        int[] tracker = new int[len];

        for (int i = 0; i < nums.length; i++) {
            tracker[binaryToInt(nums[i])] = 1;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (tracker[i] == 0) {
                ans = intToBinary(i);
                break;
            }
        }
        if(ans.length() < n){
            StringBuilder finalAns =  new StringBuilder();
            for(int i=0; i< n-ans.length(); i++){
                finalAns.append("0");
            }
            finalAns.append(ans);
            return finalAns.toString();
        }
        return ans.toString();
    }

    private int binaryToInt(String binaryNumber) {
        int val = 0;
        int pow = 0;
        for (int i = binaryNumber.length() - 1; i > -1; i--) {
            if (binaryNumber.charAt(i) == '1') {
                val += (int) Math.pow(2, pow);
            }
            pow++;
        }
        return val;
    }

    private StringBuilder intToBinary(int val) {
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            sb.append(val % 2);
            val /= 2;
        }
        return sb.reverse();
    }

    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(new Feb20_2025().findDifferentBinaryString(nums));
    }
}
