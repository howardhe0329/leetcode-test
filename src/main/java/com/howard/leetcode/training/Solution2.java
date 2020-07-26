package com.howard.leetcode.training;

import com.howard.leetcode.linkedlist.ListNode;
import com.howard.leetcode.linkedlist.ListNodeGenerator;

import java.util.Arrays;

/**
 * @author howard
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (sum / 10 == 1) cur.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode res = solution2.addTwoNumbers(ListNodeGenerator.generate(Arrays.asList(2, 4, 3)), ListNodeGenerator.generate(Arrays.asList(5, 6, 4)));
        System.out.println(res);

        res = solution2.addTwoNumbers(ListNodeGenerator.generate(Arrays.asList(5)), ListNodeGenerator.generate(Arrays.asList(5)));
        System.out.println(res);
    }
}
