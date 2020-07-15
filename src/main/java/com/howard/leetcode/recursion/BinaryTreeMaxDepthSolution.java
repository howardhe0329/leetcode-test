package com.howard.leetcode.recursion;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;

public class BinaryTreeMaxDepthSolution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) return;

    }


    public static void main(String[] args) {
        BinaryTreeMaxDepthSolution solution = new BinaryTreeMaxDepthSolution();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(3,9,20,null,null,15,7));
        int max = solution.maxDepth(root);
        System.out.println(max);
    }
}
