package com.howard.leetcode.linkedlist;

import java.util.Arrays;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = helper(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head = ListNodeGenerator.generate(Arrays.asList(1, 2, 3, 4));
        ListNode res = swapNodesInPairs.swapPairs(head);
        System.out.println(res);
    }
}
