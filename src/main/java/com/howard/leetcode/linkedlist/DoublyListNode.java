package com.howard.leetcode.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 双链表节点
 *
 * @author howard he
 * @create 2018-12-23 14:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoublyListNode<T> {

    private T data;
    private DoublyListNode<T> prev;
    private DoublyListNode<T> next;

    public DoublyListNode(T data) {
        this.data = data;
    }
}
