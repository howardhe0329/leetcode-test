package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }



    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(3, 9, 20, 15, 7));
        int res = solution104.maxDepth(root);
        System.out.println(res);
    }
}
