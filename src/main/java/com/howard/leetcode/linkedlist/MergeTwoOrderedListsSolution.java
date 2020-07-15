package com.howard.leetcode.linkedlist;

import java.util.Arrays;

/**
 * 合并两个有序链表
 *
 * @author howard he
 * @create 2018-12-25 05:29
 */
public class MergeTwoOrderedListsSolution {

    public ListNode mergeTwoListRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListRecursive(l1, l2.next);
            return l2;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 != null) {
            curr.next = p1;
        }
        if (p2 != null) {
            curr.next = p2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        MergeTwoOrderedListsSolution solution = new MergeTwoOrderedListsSolution();
        ListNode head1 = ListNodeGenerator.generate(Arrays.asList(1, 2, 4));
        ListNode head2 = ListNodeGenerator.generate(Arrays.asList(1, 3, 4));
        ListNode res = solution.mergeTwoListRecursive(head1, head2);
        System.out.println(res);
    }

}
