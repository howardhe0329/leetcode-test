package com.howard.leetcode.binary.tree;

/**
 * 树的节点
 *
 * @author howard he
 * @create 2018-12-26 15:12
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
