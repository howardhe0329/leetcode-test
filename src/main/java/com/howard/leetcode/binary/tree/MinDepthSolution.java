package com.howard.leetcode.binary.tree;

/**
 * 二叉树的最小深度
 *
 * @author howard he
 * @create 2019-01-03 13:48
 */
public class MinDepthSolution {

    private int minDepth = Integer.MAX_VALUE;

    /**
     * 计算二叉树的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }

    /**
     * 利用递归思想
     *
     * @param root
     * @return
     */
    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        return bottomUp(root);
    }

    private int bottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = bottomUp(root.left);
        int right = bottomUp(root.right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
