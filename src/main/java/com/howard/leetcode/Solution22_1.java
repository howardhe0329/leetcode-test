package com.howard.leetcode;

import java.util.ArrayList;
import java.util.List;


public class Solution22_1 {

    /**
     * 使用DFS深度优先搜索
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        dfs("", 0, 0, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, int n, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (right > left) return;
        if (left < n) dfs(str + "(", left + 1, right, n, result);
        if (right < n) dfs(str + ")", left, right + 1, n, result);
    }

    public static void main(String[] args) {
        Solution22_1 solution22 = new Solution22_1();
        List<String> result = solution22.generateParenthesis(2);
        System.out.println(result);

        result = solution22.generateParenthesis(3);
        System.out.println(result);
    }
}
