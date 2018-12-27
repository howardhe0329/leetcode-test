package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author howard he
 * @create 2018-12-26 16:52
 */
public class InorderTraversalSolution {

    /**
     * 中序遍历
     * 用递归思想实现
     *
     * 访问顺序
     * 1. 先遍历左子树
     * 2. 访问根节点
     * 3. 最后遍历右子树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inorder(root, resultList);
        return resultList;
    }

    /**
     * 中序遍历
     * @param root
     * @param resultList
     */
    private void inorder(TreeNode root, List<Integer> resultList) {
        // 基线条件，退出条件。
        if (root == null) {
            return;
        }
        // 1. 先遍历左子树
        inorder(root.left, resultList);
        // 2. 访问根节点
        resultList.add(root.val);
        // 3. 遍历右子树
        inorder(root.right, resultList);
    }
}
