package com.howard.leetcode.linkedlist;

import java.util.List;

/**
 * ListNode生成器
 *
 * @author howard he
 * @create 2018-12-20 05:18
 */
public class ListNodeGenerator {

    public static ListNode generate(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(data.get(0));
        ListNode curr = head;
        for (int i = 1; i < data.size(); i++) {
            ListNode next = new ListNode(data.get(i));
            curr.next = next;
            curr = next;
        }
        return head;
    }

    public static <T> DoublyListNode<T> generateDoublyListNode(List<T> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        DoublyListNode<T> head = new DoublyListNode<>();
        head.setData(dataList.get(0));
        DoublyListNode<T> curr = head;
        DoublyListNode<T> prev = null;
        for (int i = 1; i < dataList.size(); i++) {
            DoublyListNode node = new DoublyListNode();
            node.setData(dataList.get(i));
            curr.setNext(node);
            curr.setPrev(prev);
            prev = curr;
            curr = node;
        }
        return head;
    }
}
