package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("反转链表测试用例")
class ReverseListSolutionTest {

    private ReverseListSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ReverseListSolution();
    }

    @ParameterizedTest
    @MethodSource("createLiisNodeProvider")
    @DisplayName("反转链表迭代法测试")
    void reverseList(ListNode head) {
        ListNode result = solution.reverseList(head);
        Assertions.assertThat(result).as("正常流程测试").isNotNull();
    }

    @ParameterizedTest
    @MethodSource("createLiisNodeProvider")
    @DisplayName("反转链表递归法测试")
    void reverseListRecu(ListNode head) {
        ListNode result = solution.reverseListRecurisve(head);
        Assertions.assertThat(result).as("正常流程测试").isNotNull();
    }

    static Stream<Arguments> createLiisNodeProvider() {
        return Stream.of(
                Arguments.arguments(create1()),
                Arguments.arguments(create2())
        );
    }

    static ListNode create1() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return head;
    }

    static ListNode create2() {
        ListNode head = new ListNode(1);
        return head;
    }
}