package com.csbd.stack;

import java.util.Stack;

public class Feb10_2025 {
    // 3174. Clear Digits

    public String clearDigits(String s) {
        Stack<Character> strStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (!strStack.isEmpty()) {
                    strStack.pop();
                }
            } else {
                strStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: strStack){
            sb.append(c);
        }
        return sb.toString();

    }
}
