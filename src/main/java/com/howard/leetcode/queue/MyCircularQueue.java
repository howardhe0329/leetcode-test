package com.howard.leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环队列
 *
 * @author howard he
 * @create 2018-12-27 21:57
 */
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int length;

    public MyCircularQueue(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("参数无效");
        }
        data = new int[k];
        length = k;
        head = -1;
        tail = -1;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % length;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % length;
        }
        return true;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % length == head;
    }
}
