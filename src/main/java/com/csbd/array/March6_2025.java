package com.csbd.array;

public class March6_2025 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] marker = new int[grid.length * grid.length + 1];
        int[] ans = new int[2];

        for(int i=0; i<grid.length; i++){
            for(int n: grid[i]){
                marker[n] ++;
            }
        }

        for(int i=1; i<marker.length; i++){
            if(marker[i] == 2){
                ans[0] = i;
            }else if(marker[i] == 0){
                ans[1] = i;
            }
        }

        return ans;
    }
}
