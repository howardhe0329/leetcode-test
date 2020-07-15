package com.howard.leetcode.linkedlist;

import java.util.Arrays;

public class ReverseKGroupSolution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {    // find k + 1 node
            curr = curr.next;
            count++;
        }
        if (count == k) {   // if k+1 node is found
            curr = reverseKGroup(curr, k);  // reverse list with k+1 node as head
//            System.out.println("curr: " + curr);
//            System.out.println("head: " + head);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) {   // reverse current k-group:
                ListNode tmp = head.next;   // tmp - next head in direct part
                head.next = curr;   // preappending "direct" head to the reversed list
                curr = head;    // move head of reversed part to a new node
                head = tmp;     // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseKGroupSolution solution = new ReverseKGroupSolution();
        ListNode head = ListNodeGenerator.generate(Arrays.asList(1, 2, 3, 4, 5));
        ListNode res = solution.reverseKGroup(head, 2);
        System.out.println(res);

        System.out.println("-----------------------------------------------------------------------------------");
        head = ListNodeGenerator.generate(Arrays.asList(1, 2, 3, 4, 5));
        res = solution.reverseKGroup(head, 3);
        System.out.println(res);

    }
}
