package com.howard.leetcode.binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 生成二叉树工具
 *
 * @author howard he
 * @create 2018-12-26 15:19
 */
public class TreeNodeGenerator {

    public static TreeNode generate(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(data.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < data.size(); i += 2) {
            TreeNode t = queue.poll();
            Integer val = data.get(i);
            if (val != null) {
                TreeNode left = new TreeNode(val);
                t.left = left;
                queue.offer(t.left);
            }
            if (i >= data.size() - 1) {
                continue;
            }
            val = data.get(i + 1);
            if (val != null) {
                TreeNode right = new TreeNode(val);
                t.right = right;
                queue.offer(t.right);
            }
        }
        return root;
    }
}
