package com.howard.leetcode.stack;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author howard he
 * @create 2018-12-28 11:07
 */
public class MinStack {

    long min;
    private Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long val = stack.pop();
        if (val < 0) {
            min = min - val;
        }
    }

    public int top() {
        long val = stack.peek();
        if (val > 0) {
            return (int) (val + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
