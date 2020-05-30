package com.howard.leetcode.queue;

/**
 * Circular Deque
 *
 * @author howard he
 * @create 2019-04-15 10:22
 */
public class MyCircularDeque {

    private int[] items;
    private int head;
    private int tail;
    private int count;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        if (k < 0) return;
        items = new int[k];
        this.count = k;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        items[(--head % count + count) % count] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        items[(tail++ % count + count) % count] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : items[(head % count + count) % count];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : items[((tail - 1) % count + count) % count];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return tail == head;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return tail - head == count;
    }
}
