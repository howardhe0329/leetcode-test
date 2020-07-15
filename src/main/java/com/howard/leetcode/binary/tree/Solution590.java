package com.howard.leetcode.binary.tree;

import java.util.*;

public class Solution590 {


    public List<Integer> postorder1(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<NTreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            NTreeNode node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (NTreeNode child : node.children)
                    stack.add(child);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(NTreeNode node, List<Integer> data) {
        if (node == null) return;
        if (node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                helper(node.children.get(i), data);
            }
        }
        data.add(node.val);
    }

    public static void main(String[] args) {
        NTreeNode root = NTreeNodeGenerator.generate(Arrays.asList(1, 3, 2, 4, 5, 6), 3);
        Solution590 solution590 = new Solution590();
        List<Integer> res = solution590.postorder1(root);
        System.out.println(res);
    }
}
