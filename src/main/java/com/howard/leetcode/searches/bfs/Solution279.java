package com.howard.leetcode.searches.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Perfect Squares
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * @author howard he
 * @create 2019-04-19 10:16
 */
public class Solution279 {

    /**
     * mathematical solution
     *
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        if (isSquare(n)) {
            return 1;
        }
        while ((n & 3) == 0) {
            n >>= 2;
        }
        if ((n & 7) == 7) {
            return 4;
        }
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 0; i < sqrtN; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isSquare(int n) {
        int res = (int) Math.sqrt(n);
        return res * res == n;
    }

    /**
     * breadth-first search
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        List<Integer> perfectSquares = new ArrayList<>();
        int[] cntPerfectSquares = new int[n];
        for (int i = 1; i * i <= n; i++) {
            perfectSquares.add(i * i);
            cntPerfectSquares[i * i - 1] = 1;
        }
        if (perfectSquares.get(perfectSquares.size() - 1) == n) {
            return 1;
        }
        Queue<Integer> searchQueue = new LinkedList<>();
        for (Integer perfectSquare : perfectSquares) {
            searchQueue.offer(perfectSquare);
        }
        int currPerfetSquares = 1;
        while (!searchQueue.isEmpty()) {
            currPerfetSquares++;
            int qSize = searchQueue.size();
            for (int i = 0; i < qSize; i++) {
                int tmp = searchQueue.peek();
                for (Integer j : perfectSquares) {
                    if (tmp + j == n) {
                        return currPerfetSquares;
                    } else if ((tmp + j < n) && (cntPerfectSquares[tmp + j - 1] == 0)) {
                        cntPerfectSquares[tmp + j - 1] = currPerfetSquares;
                        searchQueue.offer(tmp + j);
                    } else if (tmp + j > n) break;
                }
                searchQueue.poll();
            }
        }
        return 0;
    }
}
