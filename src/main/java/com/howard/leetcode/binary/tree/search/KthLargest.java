package com.howard.leetcode.binary.tree.search;

/**
 * Kth Largest Element in a Stream
 *
 *
 *
 * @author howard he
 * @create 2018-12-31 21:42
 */
public class KthLargest {

    Node root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n: nums) {
            root = add(root, n);
        }
    }


    public int add(int val) {
        root = add(root, val);
        return findKthLargest();
    }

    /**
     * 从二叉搜索树中找第K大元素
     *
     * 时间复杂度 O(logN)
     *
     * @return
     */
    private int findKthLargest() {
        int count = k;
        Node walker = root;
        while (count > 0) {
            int pos = 1 + (walker.right != null ? walker.right.count : 0);
            if (count > pos) {
                count -= pos;
                walker = walker.left;
            } else if (count < pos) {
                walker = walker.right;
            } else {
                break;
            }
        }
        return walker.val;
    }

    /**
     *
     * 时间复杂度为O(logN)
     *
     * @param root
     * @param val
     * @return
     */
    private Node add(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        root.count++;
        if (val < root.val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }
        return root;
    }


    class Node {
        int val, count = 1;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }
}
