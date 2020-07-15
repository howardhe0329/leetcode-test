package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
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
    void reverseList(List<Integer> data, List<Integer> rightList) {
        ListNode result = solution.reverseList(ListNodeGenerator.generate(data));
        if (rightList.isEmpty()) {
            Assertions.assertThat(result).isNull();
        } else {
            Assertions.assertThat(ListNodeConverter.convert(result)).containsSequence(rightList);
        }
    }

    @ParameterizedTest
    @MethodSource("createLiisNodeProvider")
    @DisplayName("反转链表递归法测试")
    void reverseListRecursive(List<Integer> data, List<Integer> rightList) {
        ListNode result = solution.reverseListRecursive(ListNodeGenerator.generate(data));
        if (rightList.isEmpty()) {
            Assertions.assertThat(result).isNull();
        } else {
            List<Integer> resultList = ListNodeConverter.convert(result);
            Assertions.assertThat(resultList).containsSequence(rightList);
        }
    }

    static Stream<Arguments> createLiisNodeProvider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5), Lists.newArrayList(5, 4, 3, 2, 1)),
                Arguments.arguments(Lists.newArrayList(1), Lists.newArrayList(1)),
                Arguments.arguments(Lists.newArrayList(), Lists.newArrayList())
        );
    }

}