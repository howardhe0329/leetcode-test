package com.howard.leetcode.eighteen.stacks;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth smallest element in a sorted matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * @author howard he
 * @create 2019-03-28 10:37
 */
public class Solution378 {

    /**
     * 利用优先级队列
     *
     * Time complexity: O(klogk)
     * Space complexity: O(k)
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            heap.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = heap.poll();
            if (t.x == n - 1) {
                continue;
            }
            heap.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return heap.poll().val;
    }

    public static class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }


    /**
     * 利用优先级队列
     *
     * Time complexity: O(n^2logk)
     * Space complexity: O(k)
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue(k, Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.offer(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
