package com.howard.leetcode.sorting;

/**
 * 堆排序实现
 *
 * @author howard he
 * @create 2019-01-04 15:29
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        buildHeap(array);
        int k = array.length - 1;
        while (k > 0) {
            swap(array, 0, k);
            --k;
            heapify(array, k, 0);
        }
        return array;
    }

    /**
     * 建堆
     * @param array
     */
    private void buildHeap(int[] array) {
        for (int i = (array.length >> 1); i >= 0 ; --i) {
            heapify(array, array.length - 1, i);
        }
    }

    private void heapify(int[] array, int len, int i) {
        while (true) {
            int maxPos = i;
            if ((i << 1) + 1 <= len && array[i] < array[(i << 1) + 1]) {
                maxPos = (i << 1) + 1;
            }
            if ((i << 1) + 2 <= len && array[maxPos] < array[(i << 1) + 2]) {
                maxPos = (i << 1) + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(array, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
