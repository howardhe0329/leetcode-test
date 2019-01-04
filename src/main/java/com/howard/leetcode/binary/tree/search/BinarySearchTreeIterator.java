package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树迭代器实现
 *
 * @author howard he
 * @create 2018-12-30 20:00
 */
public class BinarySearchTreeIterator {

    private Deque<TreeNode> deque;

    public BinarySearchTreeIterator(TreeNode root) {
        deque = new LinkedList<>();
        init(root);
    }

    private void init(TreeNode curr) {
        while (curr != null) {
            deque.offer(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode node = deque.pollLast();
        TreeNode curr = node;
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                deque.offer(curr);
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}
