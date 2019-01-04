package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("二叉树路径总和")
class HasPathSumSolutionTest {

    private HasPathSumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new HasPathSumSolution();
    }

    @ParameterizedTest
    @MethodSource("providerIsTrue")
    @DisplayName("测试二叉树路径总和是true")
    void hasPathSumIsTrue(List<Integer> data, int sum) {
        boolean result = solution.hasPathSum(TreeNodeGenerator.generate(data), sum);
        Assertions.assertThat(result).as("为true").isTrue();
    }

    @ParameterizedTest
    @MethodSource("providerIsFalse")
    @DisplayName("测试二叉树路径总和是fasle")
    void hasPathSumIsFalse(List<Integer> data, int sum) {
        boolean result = solution.hasPathSum(TreeNodeGenerator.generate(data), sum);
        Assertions.assertThat(result).as("为false").isFalse();
    }

    static Stream<Arguments> providerIsTrue() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22),
                Arguments.arguments(Lists.newArrayList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 18)
        );
    }

    static Stream<Arguments> providerIsFalse() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 40)
        );
    }
}