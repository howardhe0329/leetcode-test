package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("奇偶链表")
class OddEvenListSolutionTest {

    private OddEvenListSolution solution;

    @BeforeEach
    void setUp() {
        solution = new OddEvenListSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试奇偶链表的正确输出")
    void oddEvenList(ListNode head) {
        ListNode result = solution.oddEvenList(head);
        List<Integer> resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("不能为空").isNotEmpty()
            .as("包含正确的值").containsExactlyElementsOf(ListNodeConverter.convert(head));
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 3, 4, 5)))
        );
    }
}