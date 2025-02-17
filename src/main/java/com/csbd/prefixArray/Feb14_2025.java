package com.csbd.prefixArray;

import java.util.ArrayList;
import java.util.List;

public class Feb14_2025 {

    class ProductOfNumbers {

        private List<Integer> prefixProduct;
        int size = 0;

        public ProductOfNumbers() {
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixProduct = new ArrayList<>();
                prefixProduct.add(1);
                size = 0;
            } else {
                prefixProduct.add(prefixProduct.get(size) * num);
                size++;
            }
        }

        public int getProduct(int k) {
            if (k > size) {
                return 0;
            } else {
                return prefixProduct.get(size) / prefixProduct.get(size - k);
            }
        }
    }

}
