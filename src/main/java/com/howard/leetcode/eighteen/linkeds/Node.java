package com.howard.leetcode.eighteen.linkeds;

/**
 * 随机链表节点
 *
 * @author howard he
 * @create 2019-03-21 14:35
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
