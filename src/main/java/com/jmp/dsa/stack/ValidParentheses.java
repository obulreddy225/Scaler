package com.jmp.dsa.stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Opening bracket
            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

            } else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}