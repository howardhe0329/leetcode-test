package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树中序遍历
 *
 * @author howard he
 * @create 2019-01-01 18:09
 */
public class TreeNodeOrder {

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrder(root, resultList);
        return resultList;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param resultList
     */
    private void inOrder(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, resultList);
        resultList.add(root.val);
        inOrder(root.right, resultList);
    }

    /**
     * 层级遍历
     *
     * @param root
     * @return
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode n = queue.poll();
                resultList.add(n.val);
                if (n.left == null && n.right == null) {
                    size--;
                    continue;
                }
                if (n.left != null) {
                    queue.offer(n.left);
                } else {
                    queue.offer(new TreeNode(-1));
                }
                if (n.right != null) {
                    queue.offer(n.right);
                } else {
                    queue.offer(new TreeNode(-1));
                }
                size--;
            }

        }
        return resultList;
    }


}
