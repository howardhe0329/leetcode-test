package com.howard.leetcode.eighteen.trees;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * Kth smallest element in a BST
 *
 * @author howard he
 * @create 2019-04-08 09:25
 */
public class Solution230_1 {

    /**
     *
     * Binary Search
     *
     * Time complexity: O(N)
     * Worst: O(N^2)
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
