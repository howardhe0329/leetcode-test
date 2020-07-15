package com.howard.leetcode.linkedlist;

import java.util.Arrays;

/**
 * 两两交换链表中的节点
 *
 * @author howard he
 * @create 2019-01-03 22:13
 */
public class SwapPairsSolution {

    /**
     *
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode a = curr.next;
            ListNode b = curr.next.next;
            a.next = b.next;
            curr.next = b;
            curr.next.next = a;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapPairsSolution solution = new SwapPairsSolution();
        ListNode head = ListNodeGenerator.generate(Arrays.asList(1, 2, 3, 4));
        ListNode res = solution.swapPairs(head);
        System.out.println(res);
    }

}
