package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(k), result);
        return result;
    }

    private void helper(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        // 到达叶子节点
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            helper(i + 1, n, k - 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> res = solution77.combine(4, 2);
        System.out.println(res);

    }
}
