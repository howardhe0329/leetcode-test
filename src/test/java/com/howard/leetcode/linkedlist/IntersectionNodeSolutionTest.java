package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("判断两个链表是否有相交的节点")
class IntersectionNodeSolutionTest {

    private IntersectionNodeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IntersectionNodeSolution();
    }

    @ParameterizedTest(name = "getIntersectionNode测试有相交的两个链表，返回ListNode: Test# {index}: Id: {0}")
    @MethodSource("hasIntersectionNodeProvider")
    @DisplayName("有相交")
    void getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = solution.getIntersectionNode(headA, headB);
        Assertions.assertThat(result).as("有相交的节点").isNotNull();
    }

    @ParameterizedTest(name = "getIntersectionNode测试没有相交的两个链表，返回null: Test# {index}: Id: {0}")
    @MethodSource("noHasIntersectionNodeProvider")
    @DisplayName("无相交")
    void no_getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = solution.getIntersectionNode(headA, headB);
        Assertions.assertThat(result).as("无相交的节点").isNull();
    }

    static Stream<Arguments> hasIntersectionNodeProvider() {
        return Stream.of(
                createArguments1()
        );
    }

    static Stream<Arguments> noHasIntersectionNodeProvider() {
        return Stream.of(
                createArguments2(),
                createArguments3(),
                createArguments4(),
                createArguments5()
        );
    }

    static Arguments createArguments1() {
        ListNode headA = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        headA.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        headB.next = b1;
        b1.next = b2;
        b2.next = n2;
        return Arguments.arguments(headA, headB);
    }

    static Arguments createArguments2() {
        ListNode headA = new ListNode(2);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        headA.next = n1;
        n1.next = n2;
        ListNode headB = new ListNode(1);
        ListNode b1 = new ListNode(5);
        headB.next = b1;
        return Arguments.arguments(headA, headB);
    }

    static Arguments createArguments3() {
        return Arguments.arguments(null, null);
    }

    static Arguments createArguments4() {
        ListNode headA = new ListNode(2);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        headA.next = n1;
        n1.next = n2;
        return Arguments.arguments(headA, null);
    }

    static Arguments createArguments5() {
        ListNode headB = new ListNode(1);
        ListNode b1 = new ListNode(5);
        headB.next = b1;
        return Arguments.arguments(null, headB);
    }

}