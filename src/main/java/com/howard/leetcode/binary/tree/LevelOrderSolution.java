package com.howard.leetcode.binary.tree;

import java.util.*;

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
//        return bfs(root);
        dfs(root, resultList, 1);
        return resultList;
    }

    /**
     * 广度优先搜索法实现
     * 时间复杂度是O(n)
     * 空间复杂度是O(n)
     * @param root
     * @return
     */
    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
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

    /**
     * 深度优先搜索实现（利用内存栈）
     * 时间复杂度O(n)
     *
     * @param root
     * @param resultList
     */
    private void dfs(TreeNode root, List<List<Integer>> resultList, int level) {
        if (root == null) {
            return;
        }
        if (resultList.size() < level) {
            resultList.add(new ArrayList<>());
        }
        List<Integer> levelList = resultList.get(level - 1);
        levelList.add(root.val);
        dfs(root.left, resultList, level + 1);
        dfs(root.right, resultList, level + 1);
    }

}
