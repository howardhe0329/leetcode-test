package com.howard.leetcode.queue;

/**
 * 循环队列
 *
 * @author howard he
 * @create 2018-12-27 21:57
 */
public class MyCircularQueue {

    private int[] items;
    private int head;
    private int tail;
    private int count;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        if (k < 0) return;
        items = new int[k];
        this.count = k;
        this.head = -1;
        this.tail = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) head = 0;
        tail = (tail + 1) % count;
        items[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % count;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : items[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : items[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % count == head;
    }
}
