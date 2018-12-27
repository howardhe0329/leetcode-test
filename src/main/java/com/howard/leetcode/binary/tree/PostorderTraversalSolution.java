package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历二叉树实现
 *
 * @author howard he
 * @create 2018-12-26 17:35
 */
public class PostorderTraversalSolution {

    /**
     * 后序遍历二叉树
     * <p>
     * 访问顺序:
     * 1. 先遍历左子树
     * 2. 然后遍历右子树
     * 3. 最后访问根节点
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postorder(root, resultList);
        return resultList;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private void postorder(TreeNode root, List<Integer> resultList) {
        // 基线条，退出条件
        if (root == null) {
            return;
        }
        // 1. 先遍历左子树
        postorder(root.left, resultList);
        // 2. 然后遍历右子树
        postorder(root.right, resultList);
        // 3. 最后访问根节点
        resultList.add(root.val);
    }
}
