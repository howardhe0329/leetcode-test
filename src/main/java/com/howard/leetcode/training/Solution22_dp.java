package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution22_dp {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> item = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> p = dp.get(j);
                List<String> q = dp.get(i - 1 - j);
                for (String ps : p) {
                    for (String qs : q) {
                        item.add("(" + ps + ")" + qs);
                    }
                }
            }
            dp.add(item);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        Solution22_dp solution22 = new Solution22_dp();
        List<String> result = solution22.generateParenthesis(3);
        System.out.println(result);
        System.out.println(result.size());
    }
}
