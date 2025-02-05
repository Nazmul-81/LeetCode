package com.csbd.string;

public class Feb3_25 {
    public boolean areAlmostEqual(String s1, String s2) {
        // 1790. Check if One String Swap Can Make Strings Equal

        int[] counter = new int[26];
        for (char c : s1.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            counter[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0)
                return false;
        }

        int miss = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                miss++;
        }

        if(miss > 2){
            return false;
        }

        return true;
    }
}
