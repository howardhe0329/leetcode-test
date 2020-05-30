package com.howard.leetcode.binary.tree.heap;

/**
 * 自已实现堆
 *
 * @author howard he
 * @create 2019-03-29 14:15
 */
public class SimpleHeap {

    int[] data;
    int count;
    int size;

    public SimpleHeap(int capacity) {
        data = new int[capacity + 1];
        count = capacity;
        size = 0;
    }

    /**
     * 向堆中插入一个元素
     *
     * @param val 值
     */
    public void insert(int val) {
        // heap full
        if (size >= count) {
            return;
        }
        data[++size] = val;
        int i = size;
        // 自下往上堆化, 就是当前节点和它的父节点进行比较，如果大于父节点则交换。直到树的根节点为止。
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public int removeTop() {
        // heap empty
        if (size == 0) {
            return -1;
        }
        int top = data[1];
        // 将堆最后位置的元素放到堆顶位置
        data[1] = data[size];
        size--;
        int i = 1;
        // 从上到下堆化操作，先和左子节点比较，然后和右子节点比较，找出三个节点中最大（或最小）的节点并交换。
        while (true) {
            int maxPos = i;
            if (2 * i <= size && data[i] < data[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= size && data[maxPos] < data[2 * i + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
        return top;
    }

    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
