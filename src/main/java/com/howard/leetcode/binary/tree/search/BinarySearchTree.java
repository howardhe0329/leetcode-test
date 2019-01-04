package com.howard.leetcode.binary.tree.search;

/**
 * 二叉搜索树
 *
 * @author howard he
 * @create 2018-12-31 17:53
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    /**
     * 查找指定节点
     * @param val
     * @return
     */
    public Node find(int val) {
        Node n = root;
        while (n != null) {
            if (val < n.val) {
                n = n.left;
            } else if (val > root.val) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }

    /**
     * 插入新据
     * @param val
     */
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node n = root;
        while (n != null) {
            if (val < n.val) {
                if (n.left == null) {
                    n.left = new Node(val);
                    return;
                }
                n = n.left;
            } else {
                if (n.right == null) {
                    n.right = new Node(val);
                    return;
                }
                n = n.right;
            }
        }
    }

    private void delete(int val) {
        Node curr = root;
        Node parent = null;
        while (curr != null && val != curr.val) {
            parent = curr;
            if (val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        // 没有找到要删除的节点
        if (curr == null) {
            return;
        }
        // 要删除的节点有两个子节点
        if (curr.left != null && curr.right != null) {
            Node minParent = curr;
            Node minNode = curr.right;
            while (minNode.left != null) {
                minParent = minNode;
                minNode = minNode.left;
            }
            curr.val = minNode.val;
            curr = minNode;
            parent = minParent;
        }

        // 要删除的节点没有子节点或只有一个节点
        Node child = null;
        if (curr.left != null) {
            child = curr.left;
        } else if (curr.right != null) {
            child = curr.right;
        }
        if (parent == null) {
            root = child;
        } else if (parent.left == curr) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public Node min() {
        Node min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public Node max() {
        Node max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    public static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
