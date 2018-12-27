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

@DisplayName("移除链表中元素")
class RemoveElementsSolutionTest {

    private RemoveElementsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RemoveElementsSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试移除链表中元素")
    void removeElements(ListNode head, int val) {
        ListNode result = solution.removeElements(head, val);
        List<Integer> resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("有数据").isNotEmpty()
            .as("比较").doesNotContain(val);
    }

    @ParameterizedTest
    @MethodSource("provider1")
    @DisplayName("测试移除链表中元素")
    void removeElementsForNull(ListNode head, int val) {
        ListNode result = solution.removeElements(head, val);
        List<Integer> resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("无数据").isNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 6, 3, 4, 5, 6)), 6),
            Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(6, 1, 6)), 6),
            Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(6, 1, 2, 6, 6)), 6),
            Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(6, 1, 2, 6, 6, 6, 3, 4, 5, 6, 6)), 6)
        );
    }

    static Stream<Arguments> provider1() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(null), 6),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(6)), 6),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(6, 6, 6)), 6)
        );
    }

}