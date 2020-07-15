package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        Solution236 solution236 = new Solution236();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        TreeNode res = solution236.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(res);
    }

}
