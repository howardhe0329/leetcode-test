package com.howard.leetcode.binary.tree.heap;

/**
 * 自定义堆
 *
 * @author howard he
 * @create 2019-01-02 18:26
 */
public class Heap {

    /**
     * 数组，从下标为1开始存储烽据
     */
    private int[] data;
    /**
     * 堆可以存储最大的数据个数
     */
    private int n;
    /**
     * 堆中已经存储的数据个数
     */
    private int size;

    public Heap(int capacity) {
        data = new int[capacity + 1];
        n = capacity;
        size = 0;
    }

    public void insert(int val) {
        // 表示堆满了
        if (size >= n) {
            return;
        }
        ++size;
        data[size] = val;
        int i = size;
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public void removeTop() {
        // 无数据
        if (size == 0) {
            return;
        }
        // 把树中的最后一个元素放到堆顶
        data[1] = data[size];
        --size;
        heapify(size, 1);
    }

    private void heapify(int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && data[i] < data[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && data[maxPos] < data[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 终止条件
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }


    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
