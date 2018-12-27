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

@DisplayName("二叉树的最大深度")
class MaxDepthSolutionTest {

    private MaxDepthSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaxDepthSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试二叉树的最大深度")
    void maxDepth(List<Integer> data) {
        int result =solution.maxDepth(TreeNodeGenerator.generate(data));
        System.out.println(result);
        Assertions.assertThat(result).as("大于0").isGreaterThan(0);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(3, 9, 20, null, null, 15, 7))
        );
    }
}