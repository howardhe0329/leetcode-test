package com.howard.leetcode.binary.tree.search;

public class BasicBinaryTree {

    /**
     * in order traversal of the tree
     * @param root
     */
    public void display(Node<Object> root) {
        if (root == null) return;
        if (root.left != null) display(root.left);
        System.out.println(root.data);
        if (root.right != null) display(root.right);
    }

    /**
     * This is the recursive function to find the depth of binary tree.
     * @param root
     * @return
     */
    public int depthOfTree(Node<Object> root) {
        if (root == null) return 0;
        return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
    }

    /**
     * This function returns that is it full binary tree or not?
     * @param root
     * @return
     */
    public boolean isFullBinaryTree(Node<Object> root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null)
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        else
            return false;
    }

    static class Node<V> {
        private V data;
        private Node<V> left;
        private Node<V> right;

        public Node(V data, Node<V> left, Node<V> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
