package com.csbd.stack;

import java.util.Stack;

public class Feb11_2025 {
    // 1910. Remove All Occurrences of a Substring
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= part.length() && containInStack(stack, part)) {
                int popLength = part.length();
                while (popLength > 0) {
                    stack.pop();
                    popLength--;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();

    }

    private boolean containInStack(Stack<Character> stack, String part) {
        Stack<Character> newStack = new Stack<>();
        newStack.addAll(stack);
        for (int i = part.length() - 1; i > -1; i--) {
            if (part.charAt(i) != newStack.pop())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        System.out.println(new Feb11_2025().removeOccurrences(s, part));
    }
}
