package com.howard.leetcode.binary.tree;

/**
 * 二叉树中的路径总和
 *
 * @author howard he
 * @create 2018-12-27 10:38
 */
public class HasPathSumSolution {

    /**
     * 自顶向下递归思想
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (sum == 0) {
            return true;
        } else if (sum < 0) {
            return false;
        }
        return hasPathSum(root.left, sum)
                || hasPathSum(root.right, sum);
    }
}
