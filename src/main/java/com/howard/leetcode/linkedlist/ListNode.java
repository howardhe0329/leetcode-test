package com.howard.leetcode.linkedlist;

import lombok.Data;

/**
 * 链表节点
 *
 * @author howard he
 * @create 2018-12-18 14:19
 */
@Data
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}