package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
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

    @ParameterizedTest(name = "hasCycle测试有环的链表返回 {2}: Test# {index}: Id: {0}")
    @MethodSource("listNode")
    @DisplayName("链表是否有环")
    public void hasCycle(List<Integer> data, int pos, boolean right) {
        boolean result = solution.hasCycle(ListNodeGenerator.generateCycle(data, pos));
        Assertions.assertThat(result).as("有环的链表").isEqualTo(right);
    }

    static Stream<Arguments> listNode() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(3, 2, 0, -4), 1, true),
                Arguments.arguments(Lists.newArrayList(1, 2), 0, true),
                Arguments.arguments(Lists.newArrayList(1), -1, false),
                Arguments.arguments(Lists.newArrayList(1), 0, false),
                Arguments.arguments(Lists.newArrayList(), 0, false)
        );
    }

    @ParameterizedTest(name = "hasCycleSet测试有环的链表返回false: Test# {index}: Id: {0}")
    @MethodSource("listNode")
    @DisplayName("测试有环的链表")
    void hasCycleSet(ListNode head) {
        boolean result = solution.hasCycle(head);
        Assertions.assertThat(result).as("有环的链表").isTrue();
    }

}