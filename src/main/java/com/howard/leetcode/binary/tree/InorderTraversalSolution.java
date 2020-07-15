package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 *
 * 遍历顺序是：左 -> 根 -> 右
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

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        InorderTraversalSolution solution = new InorderTraversalSolution();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(1, null, 2, 3));
        List<Integer> res = solution.inorderTraversal1(root);
        System.out.println(res);
    }
}
