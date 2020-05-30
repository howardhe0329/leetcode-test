package com.howard.leetcode.binary.tree;

/**
 * 验证是否为二叉搜索树
 *
 * @author howard he
 * @create 2019-03-05 11:07
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean inorder(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);
    }
}
