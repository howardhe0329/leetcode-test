package com.howard.leetcode.binary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 生成器
 *
 * @author howard he
 * @create 2018-12-27 14:15
 */
public class TreeLinkNodeGenerator {

    public static TreeLinkNode generate(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(data.get(0));
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < data.size(); i += 2) {
            TreeLinkNode t = queue.poll();
            Integer val = data.get(i);
            if (val != null) {
                TreeLinkNode left = new TreeLinkNode(val);
                t.left = left;
                queue.offer(t.left);
            }
            if (i >= data.size() - 1) {
                continue;
            }
            val = data.get(i + 1);
            if (val != null) {
                TreeLinkNode right = new TreeLinkNode(val);
                t.right = right;
                queue.offer(t.right);
            }
        }
        return root;
    }
}
