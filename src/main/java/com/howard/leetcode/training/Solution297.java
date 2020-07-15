package com.howard.leetcode.training;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {

    static class Codec {

        public static final String SPLIT = ",";
        public static final String NN = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.toString();
        }

        private void preOrder(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(SPLIT);
            } else {
                sb.append(node.val).append(SPLIT);
                preOrder(node.left, sb);
                preOrder(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPLIT)));
            System.out.println(nodes);
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> deque) {
            String val = deque.remove();
            if (val.equals(NN)) return null;
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeGenerator.generate(Arrays.asList(1, 2, 3, null, null, 4, 5));
        Codec codec = new Codec();
        String res = codec.serialize(root);
        System.out.println(res); // "[1,2,3,null,null,4,5]"

        TreeNode rootRes = codec.deserialize(res);
        System.out.println(rootRes);
    }
}
