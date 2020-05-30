package com.howard.leetcode.eighteen.stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution239Test {

    private Solution239 solution;

    @ParameterizedTest
    @MethodSource("maxSlidingWindowProvider")
    @DisplayName("MaxSlidingWindow")
    void MaxSlidingWindow(int[] nums, int k, int[] right) {
        solution = new Solution239();
        int[] result = solution.maxSlidingWindow(nums, k);
        assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> maxSlidingWindowProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.arguments(new int[]{}, 0, new int[]{}),
                Arguments.arguments(new int[]{1, -1}, 1, new int[]{1, -1}),
                Arguments.arguments(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5, new int[]{10, 10, 9, 2})
        );
    }
}