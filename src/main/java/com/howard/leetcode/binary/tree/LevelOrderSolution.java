package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树
 *
 * @author howard he
 * @create 2018-12-26 17:53
 */
public class LevelOrderSolution {

    /**
     * 层次遍历二叉树
     * 用广度优先搜索算法来实现
     * 知识点，利用Queue的特性
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (queueLength > 0) {
                TreeNode t = queue.poll();
                levelList.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                queueLength--;
            }
            resultList.add(levelList);
        }
        return resultList;
    }
}
