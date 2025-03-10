package com.csbd.slideingWindow;

public class March8_2025 {
    public int minimumRecolors(String blocks, int k) {
        int w = 0;
        int b = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                b++;
            } else {
                w++;
            }
        }

        int ans = w;
        for (int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i-k) == 'B'){
                b --;
            }else{
                w --;
            }
            if(blocks.charAt(i) == 'B'){
                b++;
            }else w ++;

            ans = Math.min(ans, w);
        }

        return ans;
    }
}
