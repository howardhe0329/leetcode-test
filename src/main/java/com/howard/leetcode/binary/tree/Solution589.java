package com.howard.leetcode.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution589 {

    public List<Integer> preorder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<NTreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            NTreeNode node = stack.pop();
            result.add(node.val);
            if (node.children == null) continue;
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NTreeNode root = NTreeNodeGenerator.generate(Arrays.asList(1, 3, 2, 4, 5, 6), 3);
        Solution589 solution589 = new Solution589();
        List<Integer> res = solution589.preorder(root);
        System.out.println(res);
    }
}
