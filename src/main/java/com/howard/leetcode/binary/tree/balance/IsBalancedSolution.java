package com.howard.leetcode.binary.tree.balance;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 平衡二叉树
 *
 * @author howard he
 * @create 2019-01-02 09:48
 */
public class IsBalancedSolution {

    /**
     * 验证二叉树是否为平衡二叉树
     * @param root 根节点
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
