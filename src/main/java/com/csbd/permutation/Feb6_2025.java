package com.csbd.permutation;

import java.util.HashMap;
import java.util.Map;

public class Feb6_2025 {
    // 1726. Tuple with Same Product
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];
                int product = n1 * n2;
                Integer count = map.get(product);
                if (count == null) {
                    count = 0;
                }
                map.put(product, count + 1);
            }
        }

        int ans = 0;
        for (int product : map.values()) {
            ans += permutation(product);
        }

        return ans * 8;

    }

    private int permutation(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6};
        new Feb6_2025().tupleSameProduct(arr);
    }

}
