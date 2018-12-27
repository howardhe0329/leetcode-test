package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("删除倒数第N个节点算法")
class RemoveNthFromEndSolutionTest {

    private RemoveNthFromEndSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveNthFromEndSolution();
    }

    @ParameterizedTest(name = "removeNthFromEnd测试删除倒数第N个节点的链表: Test# {index}: List: {0}; n: {1}")
    @MethodSource("createArgumentsProvider")
    @DisplayName("删除倒数第N个节点的链表")
    void removeNthFromEnd(ListNode head, int n) {
        ListNode result = solution.removeNthFromEnd(head, n);
        Assertions.assertThat(result).as("删除倒数第N个节点后").isNotNull();
    }

    @ParameterizedTest(name = "removeNthFromEnd测试删除倒数第N个节点的链表为null的情况: Test# {index}: List: {0}; n: {1}")
    @MethodSource("createArgumentsProvider1")
    @DisplayName("删除倒数第N个节点的链表为null情况")
    void removeNthFromEndForNull(ListNode head, int n) {
        ListNode result = solution.removeNthFromEnd(head, n);
        Assertions.assertThat(result).as("删除倒数第N个节点为null").isNull();
    }

    static Stream<Arguments> createArgumentsProvider() {
        return Stream.of(
                Arguments.arguments(create1(), 2),
                Arguments.arguments(create1(), 1),
                Arguments.arguments(create1(), 3),
                Arguments.arguments(create1(), 4),
                Arguments.arguments(create1(), 5),
                Arguments.arguments(create1(), 0)
        );
    }

    static Stream<Arguments> createArgumentsProvider1() {
        return Stream.of(
                Arguments.arguments(null, 2)
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
}