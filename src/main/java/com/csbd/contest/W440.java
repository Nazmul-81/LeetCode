package com.csbd.contest;

import java.util.Arrays;

public class W440 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int counter =0;
        for(int i=0; i<fruits.length; i++){
            for(int j=0; j< baskets.length; j++){
                if(baskets[j] > 0 && baskets[j] >= fruits[i]){
                    baskets[j] = -1;
                    counter++;
                    break;
                }
            }
        }
        return fruits.length - counter;
    }

    public static void main(String[] args) {
    }
}
