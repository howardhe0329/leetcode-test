package com.howard.leetcode.linkedlist;

import java.util.Arrays;

/**
 * 反转链表
 *
 * @author howard he
 * @create 2018-12-20 04:11
 */
public class ReverseListSolution {

    /**
     * 用迭代法去实现
     * <p>
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
     * <p>
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ReverseListSolution solution = new ReverseListSolution();
        ListNode head = ListNodeGenerator.generate(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(head);
        ListNode res = solution.reverseListRecursive(head);

        System.out.println(res);
    }
}
