package com.howard.leetcode.sorting;

/**
 * 归并排序
 *
 * @author howard he
 * @create 2019-02-28 14:10
 */
public class MergeSort {

    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * @param a
     * @param l
     * @param r
     * @return
     */
    private void mergeSort(int[] a, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

    }

}
