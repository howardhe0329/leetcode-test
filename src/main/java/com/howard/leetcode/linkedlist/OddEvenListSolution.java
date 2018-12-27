package com.howard.leetcode.linkedlist;

/**
 * 奇偶链表
 *
 * @author howard he
 * @create 2018-12-20 10:51
 */
public class OddEvenListSolution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数指针
        ListNode odd = head;
        ListNode curr = head.next;
        // 偶数指针
        ListNode even = curr;
        while (odd.next != null && even.next != null) {
            // 奇数next指向偶数的next
            odd.next = even.next;
            // 奇数指针向前移
            odd = odd.next;
            // 偶数next指针指向奇数的next
            even.next = odd.next;
            // 偶数指针向前移
            even = even.next;

        }

        odd.next = curr;
        return head;
    }

}
