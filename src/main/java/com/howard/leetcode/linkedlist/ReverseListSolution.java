package com.howard.leetcode.linkedlist;

/**
 * 反转链表
 *
 * @author howard he
 * @create 2018-12-20 04:11
 */
public class ReverseListSolution {

    /**
     * 用迭代法去实现
     *
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 用递归方法去实现
     *
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecurisve(ListNode head) {
        return recurisve(head, null);
    }

    private ListNode recurisve(ListNode curr, ListNode prev) {
        // 基线条年
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return recurisve(curr, prev);
    }
}
