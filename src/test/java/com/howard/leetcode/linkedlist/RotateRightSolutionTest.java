package com.howard.leetcode.linkedlist;

import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


@DisplayName("旋转链表")
@Log
class RotateRightSolutionTest {

    private RotateRightSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RotateRightSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("旋转链表")
    void rotateRight(List data, int k) {
        ListNode head = ListNodeGenerator.generate(data);
        ListNode result = solution.rotateRight(head, k);
        List resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("不为null").isNotNull()
                .as("包含").containsAll(data);
        log.info(resultList.toString());
    }

    @ParameterizedTest
    @MethodSource("providerIsNull")
    @DisplayName("旋转链表是NULL的情况")
    void rotateRightIsNull(List data, int k) {
        ListNode head = ListNodeGenerator.generate(data);
        ListNode result = solution.rotateRight(head, k);
        Assertions.assertThat(ListNodeConverter.convert(result)).as("结果为NULL").isNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 0),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 1),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 2),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 3),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 4),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 5),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 6),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 7),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), 12),
                Arguments.arguments(Lists.newArrayList(0, 1, 2), 0),
                Arguments.arguments(Lists.newArrayList(0, 1, 2), 1),
                Arguments.arguments(Lists.newArrayList(0, 1, 2), 2),
                Arguments.arguments(Lists.newArrayList(0, 1, 2), 3),
                Arguments.arguments(Lists.newArrayList(0, 1, 2), 4)
        );
    }

    static Stream<Arguments> providerIsNull() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(), 2),
                Arguments.arguments(Lists.newArrayList(), 0)
        );
    }
}