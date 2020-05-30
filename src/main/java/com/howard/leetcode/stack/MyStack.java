package com.howard.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author howard he
 * @create 2019-01-08 16:28
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q1.size();
        while (size > 1) {
            top = q1.poll();
            q2.offer(top);
            size--;
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
