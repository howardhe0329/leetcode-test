package com.howard.leetcode.training;

import java.util.Arrays;

public class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for (int i = 0; i < s.length && child < g.length; i++) {
            if (g[child] <= s[i]) child++;
        }
        return child;
    }

    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{3};
        int res = solution455.findContentChildren(g, s);
        System.out.println(res);

    }
}
