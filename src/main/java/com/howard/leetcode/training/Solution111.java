package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;

public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        return (root.left == null || root.right == null) ? leftMin + rightMin + 1 : Math.min(leftMin, rightMin) + 1;
    }

    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(3, 9, 20, 15, 7));
        int res = solution111.minDepth(root);
        System.out.println(res);

        root = TreeNodeGenerator.generate(Arrays.asList(1, 2));
        res = solution111.minDepth(root);
        System.out.println(res);

    }
}
