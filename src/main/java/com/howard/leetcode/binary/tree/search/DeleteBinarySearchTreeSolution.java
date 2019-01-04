package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 删除节点在二叉搜索树中
 *
 * @author howard he
 * @create 2018-12-30 23:57
 */
public class DeleteBinarySearchTreeSolution {

    /**
     * 时间复杂度O(h) h是树的高度
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        // 没有找到
        if (curr == null) {
            return root;
        }
        // 要删除的节点有两个子节点
        if (curr.left != null && curr.right != null) {
            TreeNode minNode = curr.right;
            TreeNode minParent = curr;
            while (minNode.left != null) {
                minParent = minNode;
                minNode = minNode.left;
            }
            curr.val = minNode.val;
            curr = minNode;
            parent = minParent;
        }
        // 要删除的节点没有节点或只有一个节点
        TreeNode child = null;
        if (curr.left != null) {
            child = curr.left;
        } else if (curr.right != null) {
            child = curr.right;
        }
        if (parent == null) {
            return child;
        }else if (parent.left == curr) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        return root;
    }

}
