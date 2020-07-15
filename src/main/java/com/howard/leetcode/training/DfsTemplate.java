package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DfsTemplate {

    public void iterate(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        recursive(root, visited);
    }

    private void recursive(TreeNode root, Set<TreeNode> visited) {
        if (root == null || visited.contains(root)) return;
        visited.add(root);
        if (root.left != null && !visited.contains(root.left)) recursive(root.left, visited);
        if (root.right != null && !visited.contains(root.right)) recursive(root.right, visited);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visited.add(node);

            // process

        }
    }
}
