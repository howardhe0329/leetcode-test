package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft == pRight) return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        int iRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[pLeft]) {
                iRootIndex = i;
                break;
            }
        }
        int leftNum = iRootIndex - iLeft;
        root.left = buildTree(preorder, pLeft + 1, pLeft + leftNum + 1, inorder, iLeft, iRootIndex);
        root.right = buildTree(preorder, pLeft + leftNum + 1, pRight, inorder, iRootIndex + 1, iRight);
        return root;
    }

    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        int[] preorders = new int[]{3, 9, 20, 15, 7};
        int[] inorders = new int[]{9, 3, 15, 20, 7};
        TreeNode res = solution105.buildTree(preorders, inorders);
        System.out.println(res);
    }
}
