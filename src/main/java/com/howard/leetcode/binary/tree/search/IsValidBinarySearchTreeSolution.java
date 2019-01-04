package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 验证是否为二叉搜索树
 *
 * @author howard he
 * @create 2018-12-30 19:14
 */
public class IsValidBinarySearchTreeSolution {

    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean inorder(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);
    }
}
