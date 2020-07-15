package com.howard.leetcode.training;

import java.util.*;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                if (node.left == n && node.right == n)
                    result.add(node.str);
                if (node.left < n)
                    queue.offer(new Node(node.str + "(", node.left + 1, node.right));
                if (node.right < n && node.right < node.left)
                    queue.offer(new Node(node.str + ")", node.left, node.right + 1));
            }
        }
        return result;
    }

    class Node {
        private String str;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> result = solution22.generateParenthesis(3);
        System.out.println(result);
        System.out.println(result.size());
    }
}
