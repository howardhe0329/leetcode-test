package com.howard.leetcode.sorting;

import java.util.Arrays;

public class HeapSort1 {

    public void sort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = (i << 1) + 1;
        int right = left + 1;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        HeapSort1 heapSort1 = new HeapSort1();
        int arr[] = {12, 11, 13, 5, 6, 7};
        heapSort1.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
