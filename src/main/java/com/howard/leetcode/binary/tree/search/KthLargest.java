package com.howard.leetcode.binary.tree.search;

/**
 * Kth Largest Element in a Stream
 *
 * @author howard he
 * @create 2018-12-31 21:42
 */
public class KthLargest {

    Node root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            root = add(root, num);
        }
    }

    public int add(int val) {
        root = add(root, val);
        return findKthLargest();
    }

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

    public int findKthLargest() {
        int count = k;
        Node walker = root;

        while (count > 0) {
            int pos = 1 + (walker.right != null ? walker.right.count : 0);
            if (count == pos) {
                break;
            }
            if (count > pos) {
                count -= pos;
                walker = walker.left;
            } else if (count < pos) {
                walker = walker.right;
            }
        }
        return walker.val;
    }

    class Node {
        int val, count = 1;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }
}
