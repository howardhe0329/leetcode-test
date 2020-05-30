package com.howard.leetcode.binary.tree.heap;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author howard he
 * @create 2019-03-29 15:34
 */
public class HeapSort1 {

    public void sort(int[] nums) {
        buildHeap(nums);
        int k = nums.length - 1;
        while (k > 1) {
            swap(nums, 1, k);
            --k;
            heapify(nums, k, 1);
        }
    }

    public void buildHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 1; --i) {
            heapify(nums, nums.length - 1, i);
        }
    }

    /**
     * 从上至下推化
     * @param nums
     * @param size
     * @param i
     */
    private void heapify(int[] nums, int size, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= size && nums[i] < nums[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= size && nums[maxPos] < nums[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (i == maxPos) {
                break;
            }
            swap(nums, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort1 sort1 = new HeapSort1();
        int[] nums = new int[] {11, 34, 21, 1, 33, 21, 18, 19, 55};

        System.out.println(Arrays.toString(nums));
        sort1.sort(nums);
//        sort1.buildHeap(nums);
        System.out.println(Arrays.toString(nums));
    }
}
