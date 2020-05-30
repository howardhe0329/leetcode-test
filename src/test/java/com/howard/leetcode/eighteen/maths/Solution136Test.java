package com.howard.leetcode.eighteen.maths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution136Test {

    private Solution136 solution;

    @ParameterizedTest
    @MethodSource("singleNumberProvider")
    @DisplayName("SingleNumber")
    void SingleNumber(int[] nums, int right) {
        solution = new Solution136();
        int result = solution.singleNumber(nums);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> singleNumberProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 2, 1}, 1),
                Arguments.arguments(new int[]{4, 1, 2, 1, 2}, 4)
        );
    }
}