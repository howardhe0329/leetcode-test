package com.howard.leetcode.linkedlist;

/**
 * 删除倒数第N个节点
 *
 * @author howard he
 * @create 2018-12-18 17:41
 */
public class RemoveNthFromEndSolution {

    /**
     * 删除倒数第N个节点
     * 思想：
     *
     * 设置两个指针 p1（慢指针）和p2 （快指针），先让p2 先走，当走到n == 1时，那么p1 和p2的位置
     * 就相差n个节点。此时当p2走到链尾时，p1就是要删除的节点。
     * 记住，记住，记住
     *
     * 时间复杂度为O（n）
     * 空间复杂度为O(1)
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        // 先创建一个假节点。并next指针指向head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 创建指针p1指向dummy
        ListNode p1 = dummy;
        // 创建指针p2指向head
        ListNode p2 = head;
        // 让p2遍历
        while (p2.next != null) {
            // p2 移动
            p2 = p2.next;
            if (n > 1) {
                n --;
            } else {
                // 当n == 1时，开始让p1移动
                p1 = p1.next;
            }
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
}
