package com.howard.leetcode.linkedlist;

import org.assertj.core.api.AbstractAssert;

/**
 * ListNode Assert
 *
 * @author howard he
 * @create 2018-12-20 10:20
 */
public class ListNodeAssert extends AbstractAssert<ListNodeAssert, ListNode> {

    public ListNodeAssert(ListNode listNode) {
        super(listNode, ListNodeAssert.class);
    }

    public static ListNodeAssert assertThat(ListNode actual) {
        return new ListNodeAssert(actual);
    }


}
