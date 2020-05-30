package com.howard.leetcode.eighteen.trees;

import com.howard.leetcode.binary.tree.TreeNode;

import java.util.Stack;

/**
 * Kth smallest element is a BST
 *
 * @author howard he
 * @create 2019-04-08 09:40
 */
public class Solution230_2 {

    /**
     * DFS in-order
     *
     * iterative
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode node = stack.pop();
            k --;
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        // never hit if k is valid
        return -1;
    }
}
