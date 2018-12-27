package com.howard.leetcode.linkedlist;

/**
 * 移除链表元素
 *
 * @author howard he
 * @create 2018-12-20 05:12
 */
public class RemoveElementsSolution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(val - 1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
