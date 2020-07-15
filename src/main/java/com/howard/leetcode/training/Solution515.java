package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.*;

public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        return new ArrayList<>(map.values());
    }

    private void dfs(TreeNode node, int depth, Map<Integer, Integer> map) {
        if (node == null) return;
        int max = map.getOrDefault(depth, Integer.MIN_VALUE);
        map.put(depth, Math.max(max, node.val));
        dfs(node.left, depth + 1, map);
        dfs(node.right, depth + 1, map);
    }

    public static void main(String[] args) {
        Solution515 solution515 = new Solution515();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(1, 3, 2, 5, 3, null, 9));
        List<Integer> result = solution515.largestValues(root);
        System.out.println(result);
    }
}
