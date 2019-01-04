package com.howard.leetcode.linkedlist;

/**
 * 两数相加
 *
 * @author howard he
 * @create 2019-01-03 15:03
 */
public class AddTwoNumbersSolution {

    /**
     * 两数相加
     * <p>
     * 时间复杂度为O(Max(M,N))
     * 空间复杂为O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
