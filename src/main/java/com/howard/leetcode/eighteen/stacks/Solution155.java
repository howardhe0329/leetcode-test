package com.howard.leetcode.eighteen.stacks;

import java.util.Stack;

public class Solution155 {

    private Stack<Long> stack;
    private long min;

    /** initialize your data structure here. */
    public Solution155() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(0l);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        if (stack.empty())
            return;
        long val = stack.pop();
        // update min
        if (val < 0)
            min = min - val;
    }

    public int top() {
        Long v = stack.peek();
        if (v == null) return 0;
        if (v > 0)
            return (int) (v + min);
        else
            return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}
