package com.howard.leetcode.eighteen.stacks;

import java.util.Stack;

/**
 * Basic Calculator II
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * @author howard he
 * @create 2019-04-01 14:06
 */
public class Solution227 {

    /**
     * @param s
     * @return
     */
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        Stack<Integer> numbers = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == len - 1) {
                if (sign == '+') {
                    numbers.push(num);
                } else if (sign == '-') {
                    numbers.push(-num);
                } else if (sign == '*') {
                    numbers.push(numbers.pop() * num);
                } else if (sign == '/') {
                    numbers.push(numbers.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int re = 0;
        for (int n : numbers) {
            re += n;
        }
        return re;
    }
}
