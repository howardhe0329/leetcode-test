package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

/**
 * 搜索二叉搜索树中的一个值
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * @author howard he
 * @create 2018-12-30 22:34
 */
public class SearchBinarySearchTreeSolution {

    /**
     * 搜索
     *
     * 时间复杂度O(logN)
     * 空间复杂度O(1)
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val == curr.val) {
                return curr;
            } else if (val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }
}
