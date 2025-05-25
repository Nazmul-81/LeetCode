package com.csbd;

import java.util.*;

public class DailyProblem {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0)
                continue;
            for (int j = 0; j < digits.length; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j)
                        continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        list.add(num);
                    }
                }
            }

        }
        int[] ans = new int[list.size()];
        List<Integer> list1 = new ArrayList<>(list);
        Collections.sort(list1);
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list1.get(i);
        }
        return ans;
    }

    public static int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000000 + 7;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int[] nxt = new int[26];
            for (int j = 1; j < 26; j++) {
                nxt[j] = freq[j - 1] % MOD;
            }
            nxt[0] = freq[25] % MOD;
            nxt[1] = (nxt[1] + freq[25]) % MOD;
            freq = nxt;
        }

        int count = 0;
        for (int f : freq) {
            count = (count + f) % MOD;
        }

        return count;
    }


    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();

        int pre = -1;

        for (int i = 0; i < words.length; i++) {
            if (pre != groups[i]) {
                pre = groups[i];
                ans.add(words[i]);
            }
        }

        return ans;

    }

    public String triangleType(int[] nums) {

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || b + c <= a || c + a <= b) {
            return "none";
        }
        if (a == b && b == c) {
            return "equilateral";
        }
        if (a == b || b == c || c == a) {
            return "isosceles";
        }
        return "scalene";

    }


    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] delta = new int[nums.length + 1];
        for (int[] q : queries) {
            delta[q[0]]++;
            delta[q[1] + 1]--;
        }

        for (int i = 1; i < delta.length; i++) {
            delta[i] = delta[i - 1] + delta[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (delta[i] < nums[i])
                return false;
        }
        return true;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                if (c == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            Integer previousCount = map.getOrDefault(word, 0);
            map.put(word, previousCount + 1);
        }

        int counter = 0;
        boolean isSameCharPairTaken = false;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().charAt(0) == entry.getKey().charAt(1)) {
                if (entry.getValue() % 2 != 0) {
                    if (!isSameCharPairTaken) {
                        counter++;
                        isSameCharPairTaken = true;
                    }
                }
                counter += (entry.getValue() / 2 ) * 2;

            } else {
                StringBuilder reverse = new StringBuilder(entry.getKey()).reverse();
                counter += Math.min(entry.getValue(), map.getOrDefault(reverse.toString(), 0));
            }
        }
        return counter * 2;
    }


    public static void main(String[] args) {
        String[] words = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        System.out.println(longestPalindrome(words));
    }
}
