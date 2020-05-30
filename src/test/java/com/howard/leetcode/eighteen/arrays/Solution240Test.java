package com.howard.leetcode.eighteen.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution240Test {

    private Solution240 solution;

    @ParameterizedTest
    @MethodSource("searchMatrixProvider")
    @DisplayName("SearchMatrix")
    void SearchMatrix(int[][] matrix, int target, boolean right) {
        solution = new Solution240();
        boolean result = solution.searchMatrix(matrix, target);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> searchMatrixProvider() {
        return Stream.of(
                Arguments.arguments(generate(), 5, true),
                Arguments.arguments(generate(), 20, false)
        );
    }

    private static int[][] generate() {
        return new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
    }
}