package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;

public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return inorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean inorder(TreeNode node, int min, int max) {
        if (node == null) return true;
        return (node.val > min && node.val < max) && (inorder(node.left, min, node.val) && inorder(node.right, node.val, max));
    }

    public static void main(String[] args) {
        Solution98 solution98 = new Solution98();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(2, 1, 3));
        boolean res = solution98.isValidBST(root);
        System.out.println(res);


        root = TreeNodeGenerator.generate(Arrays.asList(5, 1, 4, null, null, 3, 6));
        res = solution98.isValidBST(root);
        System.out.println(res);
    }
}