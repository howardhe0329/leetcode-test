package com.howard.leetcode.binary.tree.balance;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author howard he
 * @create 2019-01-02 10:55
 */
public class SortedArrayToBSTSolution {

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null ||  nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = l + ((r - l) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }

}
