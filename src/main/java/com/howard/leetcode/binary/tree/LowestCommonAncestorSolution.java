package com.howard.leetcode.binary.tree;

/**
 * 二叉树的最近公共祖先
 *
 * @author howard he
 * @create 2019-01-01 12:53
 */
public class LowestCommonAncestorSolution {

    /**
     * 最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
