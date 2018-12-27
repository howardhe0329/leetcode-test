package com.howard.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ListNode转换器
 *
 * @author howard he
 * @create 2018-12-20 10:27
 */
public class ListNodeConverter {

    public static List<Integer> convert(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode n = head;
        Stream.Builder<Integer> builder = Stream.builder();
        while (n != null) {
            builder.add(n.val);
            n = n.next;
        }
        return builder.build().collect(Collectors.toList());
    }

    public static <T> List<T> convert(DoublyListNode<T> head) {
        if (head == null) {
            return null;
        }
        DoublyListNode<T> n = head;
        List<T> resultList = new ArrayList<>();
        while (n != null) {
            resultList.add(n.getData());
            n = n.getNext();
        }
        return resultList;
    }
}
