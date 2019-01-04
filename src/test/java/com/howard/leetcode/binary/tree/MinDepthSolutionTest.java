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

@DisplayName("求出二叉树的最小深度")
class MinDepthSolutionTest {

    private MinDepthSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinDepthSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("最小深度")
    void minDepth(List<Integer> data, int right) {
        int result = solution.minDepth(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(3, 9, 20, null, null, 15, 7), 2),
                Arguments.arguments(Lists.newArrayList(1, 2), 2),
                Arguments.arguments(Lists.newArrayList(1), 1),
                Arguments.arguments(Lists.newArrayList(), 0),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, null, null, 5), 3),
                Arguments.arguments(Lists.newArrayList(-9,-3,2,null,4,4,0,-6,null,-5), 3)
        );
    }
}