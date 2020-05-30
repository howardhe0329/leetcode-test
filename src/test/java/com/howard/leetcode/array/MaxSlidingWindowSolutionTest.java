package com.howard.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("滑动窗口最大值")
class MaxSlidingWindowSolutionTest {

    private MaxSlidingWindowSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaxSlidingWindowSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试")
    void maxSlidingWindow(int[] nums, int k, int[] right) {
        int[] result = solution.maxSlidingWindow(nums, k);
        Assertions.assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.arguments(new int[]{}, 0, new int[]{}),
                Arguments.arguments(new int[]{7, 2, 4}, 2, new int[]{7, 4}),
                Arguments.arguments(new int[]{1, 3, 1, 2, 0, 5}, 3, new int[]{3, 3, 2, 5})
        );
    }
}