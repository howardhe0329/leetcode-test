package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 二叉搜索最近公共祖先
 *
 * @author howard he
 * @create 2019-03-11 10:23
 * @see LowestCommonAncestorSolution
 */
public class Solution235 {

    /**
     * 最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
