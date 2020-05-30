package com.howard.leetcode.linkedlist;

/**
 * 环形链表II
 *
 * @author howard he
 * @create 2018-12-18 15:49
 */
public class HasCycleSolutionII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != null) {
                    if (slow == fast) {
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }
}
