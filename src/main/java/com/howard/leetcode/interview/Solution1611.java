package com.howard.leetcode.interview;

import java.util.*;

public class Solution1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        return null;
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1611 solution1611 = new Solution1611();
        int[] res = solution1611.divingBoard1(1, 2, 6);
        System.out.println(Arrays.toString(res));

    }
}
