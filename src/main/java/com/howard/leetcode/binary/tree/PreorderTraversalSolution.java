package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历二叉树实现
 *
 * @author howard he
 * @create 2018-12-26 15:14
 */
public class PreorderTraversalSolution {

    /**
     * 前序遍历
     * 用递归的思想实现
     *
     * 访问顺序
     * 1. 根节点
     * 2. 左子树
     * 3. 右子树
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        preorder(root, resultList);
        return resultList;
    }

    /**
     * 递归实现
     * @param root
     * @param resultList 最终结果
     */
    private void preorder(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        resultList.add(root.val);
        preorder(root.left, resultList);
        preorder(root.right, resultList);
    }

}
