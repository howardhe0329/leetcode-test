package com.howard.leetcode.binary.tree;

import java.util.*;

public class Solution429 {

    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
            int size = queue.size();
            while (size-- > 0) {
                NTreeNode node = queue.poll();
                item.add(node.val);
                if (node.children != null) {
                    for (NTreeNode child: node.children)
                        queue.offer(child);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution429 solution429 = new Solution429();
        NTreeNode root = NTreeNodeGenerator.generate(Arrays.asList(1, 3, 2, 4, 5, 6), 3);
        List<List<Integer>> res = solution429.levelOrder(root);
        System.out.println(res);
    }
}
