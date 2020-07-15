package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left + 1) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = helper(nums, left, mid - 1);
        n.right = helper(nums, mid + 1, right);
        return n;
    }

    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        int[] nums = new int[] {-10,-3,0,5,9};
        TreeNode res = solution108.sortedArrayToBST(nums);
        System.out.println(res);
    }
}
