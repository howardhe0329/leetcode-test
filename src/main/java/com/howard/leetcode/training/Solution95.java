package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) return result;

        return result;
    }

    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();
        List<TreeNode> res = solution95.generateTrees(3);

        System.out.println(res);
    }
}
