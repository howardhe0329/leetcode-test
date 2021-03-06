package com.howard.leetcode.binary.tree;

import java.util.*;

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

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        PostorderTraversalSolution solution = new PostorderTraversalSolution();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(1, null, 2, 3));
        List<Integer> res = solution.postorderTraversal1(root);
        System.out.println(res);
    }
}
