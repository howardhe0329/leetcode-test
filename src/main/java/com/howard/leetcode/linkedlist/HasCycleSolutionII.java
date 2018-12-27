package com.howard.leetcode.linkedlist;

/**
 * 环形链表II
 *
 * @author howard he
 * @create 2018-12-18 15:49
 */
public class HasCycleSolutionII {

    /**
     * 用快慢指针思想,
     * 1. 先证明是否为环形链表
     * 2. 然后找出环的起始节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 是否有环
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
