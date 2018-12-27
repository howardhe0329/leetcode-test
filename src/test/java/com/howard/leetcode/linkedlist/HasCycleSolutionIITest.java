package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("有环的链表的环的起点节点")
class HasCycleSolutionIITest {

    private HasCycleSolutionII solution;

    @BeforeEach
    void setUp() {
        solution = new HasCycleSolutionII();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "detectCycle测试有环的链表返回ListNode: Test# {index}: Id: {0}")
    @DisplayName("测试有环的链表的环起点节点")
    @MethodSource("hasCycleListNodeProvider")
    void detectCycle(ListNode head) {
        ListNode result = solution.detectCycle(head);
        Assertions.assertThat(result).as("不为null").isNotNull();
    }

    @ParameterizedTest(name = "detectCycle测试无环的链表返回null: Test# {index}: Id: {0}")
    @DisplayName("测试无环的链表的情况")
    @MethodSource("no_hasCycleListNodeProvider")
    void detectCycle_no_cycle(ListNode head) {
        ListNode result = solution.detectCycle(head);
        Assertions.assertThat(result).as("为null").isNull();
    }

    static Stream<Arguments> hasCycleListNodeProvider() {
        return Stream.of(
          Arguments.arguments(createOne()),
                Arguments.arguments(createTwo())
        );
    }

    static ListNode createOne() {
        ListNode head = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(-4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;
        return head;
    }

    static ListNode createTwo() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        one.next = head;
        return head;
    }

    static Stream<Arguments> no_hasCycleListNodeProvider() {
        return Stream.of(
                Arguments.arguments(createNoCycleListNode()),
                Arguments.arguments(createNoCycleListNode1()),
                Arguments.arguments(createNoCycleListNodeForNull())
        );
    }

    static ListNode createNoCycleListNode() {
        ListNode head = new ListNode(1);
        return head;
    }

    static ListNode createNoCycleListNode1() {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        return head;
    }

    static ListNode createNoCycleListNodeForNull() {
        return null;
    }
}