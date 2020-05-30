package com.howard.leetcode.eighteen.linkeds;

import com.howard.leetcode.linkedlist.ListNode;

/**
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author howard he
 * @create 2019-03-25 10:30
 */
public class Solution206 {

    /**
     * recursively
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * iteratively
     *
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
