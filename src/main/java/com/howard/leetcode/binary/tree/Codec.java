package com.howard.leetcode.binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树结构数据
 *
 * @author howard he
 * @create 2019-01-01 17:57
 */
public class Codec {

    /**
     * 序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode n = queue.poll();
                if (n == null) {
                    result.append("null,");
                    size--;
                    continue;
                } else {
                    result.append(n.val).append(",");
                }
                queue.offer(n.left);
                queue.offer(n.right);
                size --;
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < array.length; i += 2) {
            TreeNode t = queue.poll();
            Integer val = null;
            if (!array[i].trim().equals("null")) {
                val = Integer.parseInt(array[i].trim());
            }
            if (val != null) {
                TreeNode left = new TreeNode(val);
                t.left = left;
                queue.offer(t.left);
            }
            if (i >= array.length - 1) {
                continue;
            }
            val = null;
            if (!array[i + 1].trim().equals("null")) {
                val = Integer.parseInt(array[i + 1].trim());
            }
            if (val != null) {
                TreeNode right = new TreeNode(val);
                t.right = right;
                queue.offer(t.right);
            }
        }
        return root;
    }
}
