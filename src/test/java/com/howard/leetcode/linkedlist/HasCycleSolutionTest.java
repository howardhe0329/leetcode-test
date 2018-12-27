package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("测试链表是否有环")
class HasCycleSolutionTest {

    private HasCycleSolution solution;

    @BeforeEach
    void setUp() {
        solution = new HasCycleSolution();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "hasCycle测试有环的链表返回true: Test# {index}: Id: {0}")
    @MethodSource("listNode")
    @DisplayName("链表有环")
    public void hasCycle(ListNode head) {
        boolean result = solution.hasCycle(head);
        Assertions.assertThat(result).as("有环的链表").isTrue();
    }

    @ParameterizedTest(name = "no_hasCycle测试无环的链表返回false: Test# {index}: Id: {0}")
    @MethodSource("noCycleListNode")
    @DisplayName("测试无环的链表")
    public void no_hasCycle(ListNode head) {
        boolean result = solution.hasCycle(head);
        Assertions.assertThat(result).as("无环的链表").isFalse();
    }

    static Stream<Arguments> noCycleListNode() {
        return Stream.of(
                Arguments.arguments(createNoCycleListNode()),
                Arguments.arguments(createNoCycleListNodeForNull())
        );
    }

    static Stream<Arguments> listNode() {
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

    static ListNode createNoCycleListNode() {
        ListNode head = new ListNode(1);
        return head;
    }

    static ListNode createNoCycleListNodeForNull() {
        return null;
    }

    @ParameterizedTest(name = "hasCycleSet测试有环的链表返回false: Test# {index}: Id: {0}")
    @MethodSource("listNode")
    @DisplayName("测试有环的链表")
    void hasCycleSet(ListNode head) {
        boolean result = solution.hasCycle(head);
        Assertions.assertThat(result).as("有环的链表").isTrue();
    }

    @ParameterizedTest(name = "no_hasCycleSet测试无环的链表返回false: Test# {index}: Id: {0}")
    @MethodSource("noCycleListNode")
    @DisplayName("测试无环的链表")
    void no_hasCycleSet(ListNode head) {
        boolean result = solution.hasCycle(head);
        Assertions.assertThat(result).as("无环的链表").isFalse();
    }
}