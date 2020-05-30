package com.howard.leetcode.eighteen.trees;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * Kth smallest element is a BST
 *
 * @author howard he
 * @create 2019-04-08 09:37
 */
public class Solution230 {

    private int count;
    private int number;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (--count == 0) {
            number = root.val;
            return;
        }
        helper(root.right);
    }
}
