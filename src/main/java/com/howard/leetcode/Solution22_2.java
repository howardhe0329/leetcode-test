package com.howard.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution22_2 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left == 0 && node.right == 0)
                result.add(node.str);
            if (node.left > 0)
                queue.offer(new Node(node.str + "(", node.left - 1, node.right));
            if (node.right > 0 && node.left < node.right)
                queue.offer(new Node(node.str + ")", node.left, node.right - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution22_2 solution22 = new Solution22_2();
        List<String> result = solution22.generateParenthesis(2);
        System.out.println(result);

        result = solution22.generateParenthesis(3);
        System.out.println(result);
    }

    static class Node {
        /* 当前得到的字符串 */
        private String str;
        /* 剩余左括号数量 */
        private int left;
        /* 剩余右括号数量 */
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
}
