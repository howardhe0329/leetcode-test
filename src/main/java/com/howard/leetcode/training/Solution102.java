package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.*;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> itesms = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                itesms.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(itesms);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(3,9,20,null,null,15,7));
        List<List<Integer>> res = solution102.levelOrder(root);
        System.out.println(res);

    }
}
