package com.coding.exercise.util;

import com.coding.exercise.model.BalanceTestResult;

import java.util.Stack;

public class BalancedBracket {

    public static BalanceTestResult isBalancedBrackets(String value) {
        Stack<Character> stack = new Stack<>();
        char upperElement = 0;
        for (int i = 0; i < value.length(); i++) {
            if (!stack.isEmpty()) {
                upperElement = stack.peek();
            }
            stack.push(value.charAt(i));
            if (!stack.isEmpty() && stack.size() > 1) {
                if ((upperElement == '[' && stack.peek() == ']') ||
                        (upperElement == '{' && stack.peek() == '}') ||
                        (upperElement == '(' && stack.peek() == ')')) {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return stack.isEmpty()
                ? new BalanceTestResult(value, true)
                : new BalanceTestResult(value, false);
    }

}
