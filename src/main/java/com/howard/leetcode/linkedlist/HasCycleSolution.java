package com.howard.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 *
 * leetcode
 *
 * @author howard he
 * @create 2018-12-18 14:12
 */
public class HasCycleSolution {

    /**
     * 用快慢双指针的方法
     * 快指针每次移动2步
     * 慢指针每次移动1步
     *
     * 如果有环，肯定会slow和fast相遇，也就是slow == fast
     *
     * 时间复杂度 O（n）
     * 空间复杂度 O（1）
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用Set集合存储已遍历的节点，如果发现已有就证明有环
     * 时间复杂度 O（n）
     * Space 复杂度 O(n)
     * @param head
     * @return
     */
    public boolean hasCycleSet(ListNode head) {
        Set<ListNode> dict = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (dict.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

}
