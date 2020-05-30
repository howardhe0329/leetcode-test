package com.howard.leetcode.eighteen.stacks;

import java.util.Stack;

/**
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 *
 * @author howard he
 * @create 2019-03-27 09:21
 */
public class MinStack {

    private Stack<Long> stack;
    private long min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
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
        if (stack.empty()) {
            return;
        }
        long val = stack.pop();
        // update min value
        if (val < 0) {
            min = min - val;
        }
    }

    public int top() {
        long val = stack.peek();
        if (val > 0) {
            return (int) (min + val);
        } else {
            return (int) min;
        }

    }

    public int getMin() {
        return (int) min;
    }
}
