package com.howard.leetcode.binary.tree;

import java.util.*;

/**
 * 对称二叉树
 *
 * @author howard he
 * @create 2018-12-27 09:35
 */
public class IsSymmetricSolution {

    /**
     * 是否为对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
//        return symmetric(root.left, root.right);
        return isSymmetricBFS(root);
    }

    /**
     * 利用递归的思想
     *
     * 对称的含义是：
     * 左子树上的节点和右子树上的节点是一样的。
     *
     * @param t1
     * @param t2
     * @return
     */
    private boolean symmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null && t2 != null ||
                (t1 != null && t2 == null) ||
                (t1.val != t2.val)) {
            return false;
        }
        return symmetric(t1.left, t2.right) && symmetric(t1.right, t2.left);
    }

    /**
     * 利用广度优先搜索
     * @param root
     * @return
     */
    private boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            int length = deque.size();
            while (length > 0) {
                TreeNode t1 = deque.pollFirst();
                TreeNode t2 = deque.pollLast();
                if (t1 == null && t2 != null ||
                        (t1 != null && t2 == null) ||
                        (t1 != null && t2 != null && t1.val != t2.val)) {
                    return false;
                }
                if (t1 != null) {
                    deque.offerFirst(t1.left);
                    deque.offerFirst(t1.right);
                }
                if (t2 != null) {
                    deque.offerLast(t2.right);
                    deque.offerLast(t2.left);
                }
                length -= 2;
            }
        }
        return true;
    }
}
