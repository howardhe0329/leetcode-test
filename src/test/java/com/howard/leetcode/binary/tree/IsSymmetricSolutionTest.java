package com.howard.leetcode.binary.tree;

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

@DisplayName("是否为对称二叉树")
class IsSymmetricSolutionTest {

    private IsSymmetricSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsSymmetricSolution();
    }

    @ParameterizedTest
    @MethodSource("providerIsTrue")
    @DisplayName("测试是否为对称二叉树")
    void isSymmetricIsTrue(List<Integer> data) {
        boolean result = solution.isSymmetric(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).as("是对称二叉树").isTrue();
    }

    @ParameterizedTest
    @MethodSource("providerIsFalse")
    @DisplayName("测试是否为对称二叉树")
    void isSymmetricIsFalse(List<Integer> data) {
        boolean result = solution.isSymmetric(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).as("不是对称二叉树").isFalse();
    }

    static Stream<Arguments> providerIsTrue() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 2, 3, 4, 4, 3)),
                Arguments.arguments(Lists.newArrayList())
        );
    }

    static Stream<Arguments> providerIsFalse() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 2, null, 3, null, 3)),
                Arguments.arguments(Lists.newArrayList(2, 3, 3, 4, 5, null, 4))
        );
    }
}