package com.howard.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    /**
     * 使用DFS深度优先搜索
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) dfs(str + "(", left - 1, right, result);
        if (left < right) dfs(str + ")", left, right - 1, result);
    }


    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> result = solution22.generateParenthesis(2);
        System.out.println(result);

        result = solution22.generateParenthesis(3);
        System.out.println(result);


    }
}
