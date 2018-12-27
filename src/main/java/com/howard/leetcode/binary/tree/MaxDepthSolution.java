package com.howard.leetcode.binary.tree;

/**
 * 二叉树的最大深度
 *
 * @author howard he
 * @create 2018-12-26 22:13
 */
public class MaxDepthSolution {

    private int maxDepth;

    /**
     * 二叉树的最大深度
     * 利用递归的思想
     * <p>
     * 1. 自顶向下
     * 2. 自底向上
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        topDown(root, 1);
//        return maxDepth;
        return bottomUp(root);
    }

    /**
     * 自顶向下
     *
     * @param root
     */
    private void topDown(TreeNode root, int result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, result);
        }
        topDown(root.left, result + 1);
        topDown(root.right, result + 1);
    }

    private int bottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = bottomUp(root.left);
        int rightDepth = bottomUp(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
