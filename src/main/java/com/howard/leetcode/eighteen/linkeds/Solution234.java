package com.howard.leetcode.eighteen.linkeds;

import com.howard.leetcode.linkedlist.ListNode;

/**
 *
 *
 *
 * @author howard he
 * @create 2019-03-26 09:29
 */
public class Solution234 {

    /**
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
