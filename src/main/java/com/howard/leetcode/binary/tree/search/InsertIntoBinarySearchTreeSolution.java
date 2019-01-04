package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 插入到二叉搜索树中
 *
 * @author howard he
 * @create 2018-12-30 22:58
 */
public class InsertIntoBinarySearchTreeSolution {

    /**
     * 插入到二叉搜索树中
     *
     * 时间复杂为O(logN)
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null && curr.right != null
                && val > curr.left.val && val < curr.right.val) {
                int temp = curr.val;
                curr.val = val;
                val = temp;
            }
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            }
        }
        newNode.val = val;
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        order(root, new TreeNode(val));
        return root;
    }

    private void order(TreeNode curr, TreeNode newNode) {
        if (curr == null) {
            return;
        }
        if (newNode.val < curr.val) {
            if (curr.left == null) {
                curr.left = newNode;
                return;
            }
            order(curr.left, newNode);
        } else {
            if (curr.right == null) {
                curr.right = newNode;
                return;
            }
            order(curr.right, newNode);
        }
    }
}
