package com.howard.leetcode.eighteen.stacks;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author howard he
 * @create 2019-04-02 10:57
 */
public class Solution150 {

    /**
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token: tokens) {
            if (token.equalsIgnoreCase("+")) {
                numbers.push(numbers.pop() + numbers.pop());
            } else if (token.equalsIgnoreCase("-")) {
                int a = numbers.pop();
                int b = numbers.pop();
                numbers.push(b - a);
            } else if (token.equalsIgnoreCase("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            } else if (token.equalsIgnoreCase("/")) {
                int a = numbers.pop();
                int b = numbers.pop();
                numbers.push(b / a);
            } else {
                numbers.push(Integer.valueOf(token));
            }
        }
        return numbers.pop();
    }
}
