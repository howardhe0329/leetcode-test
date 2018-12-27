package com.howard.leetcode.linkedlist;

/**
 * 回文链表
 *
 * @author howard he
 * @create 2018-12-20 18:48
 */
public class PalindromeLinkedListSolution {

    /**
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null && curr.next != null) {
            next = curr.next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return true;
    }
}
