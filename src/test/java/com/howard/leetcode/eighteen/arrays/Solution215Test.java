package com.howard.leetcode.eighteen.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution215Test {

    private Solution215 solution;

    @ParameterizedTest
    @MethodSource("findKthLargestProvider")
    @DisplayName("FindKthLargest")
    void FindKthLargest(int[] nums, int k, int right) {
        solution = new Solution215();
        int result = solution.findKthLargest(nums, k);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> findKthLargestProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.arguments(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }
}