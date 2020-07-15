package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PreorderTraversalSolution solution = new PreorderTraversalSolution();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(1, null, 2, 3));
        List<Integer> res = solution.preorderTraversal1(root);
        System.out.println(res);
    }

}
