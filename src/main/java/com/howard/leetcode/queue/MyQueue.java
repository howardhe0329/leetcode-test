package com.howard.leetcode.queue;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author howard he
 * @create 2019-01-08 16:11
 */
public class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }
}
