package com.howard.leetcode.binary.tree;

import java.util.Arrays;

public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Solution226 solution226 = new Solution226();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
        TreeNode res = solution226.invertTree(root);

        System.out.println(res);
    }
}
