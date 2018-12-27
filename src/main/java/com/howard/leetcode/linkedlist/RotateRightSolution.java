package com.howard.leetcode.linkedlist;

/**
 * 旋转链表
 *
 * @author howard he
 * @create 2018-12-25 17:25
 */
public class RotateRightSolution {

    /**
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        curr = head;
        ListNode right = null;
        ListNode left = head;
        int offset = 0;
        k = size - k;
        while (curr != null) {
            offset++;
            if (offset == k) {
                right = curr.next;
                left.next = null;
                curr = right;
            } else if (offset < k) {
                left = left.next;
                curr = curr.next;
            } else {
                if (curr.next == null) {
                    curr.next = head;
                    break;
                }
                curr = curr.next;
            }
        }
        return right;
    }
}
