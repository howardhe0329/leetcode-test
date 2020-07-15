package com.howard.leetcode.offer;

import java.util.*;

public class Solution40 {

    private int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int lo, int hi, int k) {
        int j = partition(arr, lo, hi);
        if (j == k)
            return Arrays.copyOf(arr, j + 1);
        return j > k ? quickSearch(arr, lo, j - 1, k) : quickSearch(arr, j + 1, hi, k);
    }

    private int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < v);
            while (--j >= lo && arr[j] > v);
            if (i >= j) break;
            swap(arr, i, j);
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 用大顶堆，这样的话时间复杂度是O(NlogK)
     * 用小顶堆的话，时间复杂度是O(NlogN)
     * @param arr
     * @param k
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes", "ConstantConditions"})
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(arr.length, Comparator.reverseOrder());
        for (int num: arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            } else if (num < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : priorityQueue) {
            res[idx++] = num;
        }
        return res;
    }

    private int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int num : arr) {
            if (count < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
                continue;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1)
                    map.pollLastEntry();
                else
                    map.put(entry.getKey(), entry.getValue() - 1);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0)
                res[idx++] = entry.getKey();
        }
        return res;
    }


    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] nums = new int[]{3, 2, 1};
        int k = 2;
        int[] res = solution40.getLeastNumbers1(nums, k);
        System.out.println(Arrays.toString(res));

        nums = new int[]{0, 1, 2, 1};
        k = 1;
        res = solution40.getLeastNumbers1(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
