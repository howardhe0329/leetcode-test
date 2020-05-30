package com.howard.leetcode.eighteen.linkeds;

/**
 * 复制带随机指针的链表
 *
 * @author howard he
 * @create 2019-03-21 14:37
 */
public class Solution138 {

    public Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val, next, null);
            curr.next = copy;
            curr = next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyHead = head.next;
        while (curr != null) {
            Node next = curr.next.next;
            Node copy = curr.next;
            curr.next = next;
            if (next != null) {
                copy.next = next.next;
            }
            curr = next;
        }
        return copyHead;
    }
}
