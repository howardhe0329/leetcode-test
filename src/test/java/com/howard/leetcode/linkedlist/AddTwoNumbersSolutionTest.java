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

@DisplayName("两个链表相加")
class AddTwoNumbersSolutionTest {

    private AddTwoNumbersSolution solution;

    @BeforeEach
    void setUp() {
        solution = new AddTwoNumbersSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("两数相加")
    void addTwoNumbers(List<Integer> l1, List<Integer> l2, List<Integer> right) {
        ListNode result = solution.addTwoNumbers(ListNodeGenerator.generate(l1), ListNodeGenerator.generate(l2));
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(ListNodeConverter.convert(result)).containsAll(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(2, 4, 3),
                        Lists.newArrayList(5, 6, 4),
                        Lists.newArrayList(7, 0, 8)),
                Arguments.arguments(Lists.newArrayList(2, 4, 3, 1),
                        Lists.newArrayList(5, 6, 4),
                        Lists.newArrayList(7, 0, 8, 1)),
                Arguments.arguments(Lists.newArrayList(2, 4, 3),
                        Lists.newArrayList(5, 6, 4, 1),
                        Lists.newArrayList(7, 0, 8, 1)),
                Arguments.arguments(Lists.newArrayList(2, 4, 5),
                        Lists.newArrayList(5, 6, 4, 1),
                        Lists.newArrayList(7, 0, 0, 2)),
                Arguments.arguments(Lists.newArrayList(5),
                        Lists.newArrayList(5),
                        Lists.newArrayList(0, 1))
        );
    }
}