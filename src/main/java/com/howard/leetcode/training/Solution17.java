package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        char[] dict = new char[] {'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        dfs(0, digits, new StringBuilder(), result, dict);
        return result;
    }

    private void dfs(int level, String digits, StringBuilder temp, List<String> result, char[] dict) {
        if (level == digits.length()) {
            result.add(temp.toString());
            return;
        }
        int index = digits.charAt(level) - '2';
        int k = (index == 5 || index == 7) ? 4 : 3;
        for (int i = 0; i < k; i++) {
            temp.append((char)(dict[index] + i));
            dfs(level + 1, digits, temp, result, dict);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> res = solution17.letterCombinations("23");
        System.out.println(res);

        res = solution17.letterCombinations("29");
        System.out.println(res);

        res = solution17.letterCombinations("2");
        System.out.println(res);

        res = solution17.letterCombinations("");
        System.out.println(res);

        res = solution17.letterCombinations("234");
        System.out.println(res);

    }
}
