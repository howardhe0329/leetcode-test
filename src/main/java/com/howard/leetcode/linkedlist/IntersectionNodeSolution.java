package com.howard.leetcode.linkedlist;

/**
 * 判断两个链表是否相交
 *
 * @author howard he
 * @create 2018-12-18 16:50
 */
public class IntersectionNodeSolution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null ? headB : a.next);
            b = (b == null ? headA : b.next);
        }
        return a;
    }
}
