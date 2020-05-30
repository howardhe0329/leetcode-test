package com.howard.leetcode.eighteen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("搜索二维矩阵")
class Solution3Test {

    private Solution3 solution;

    @ParameterizedTest
    @MethodSource("searchMatrixProvider")
    @DisplayName("SearchMatrix")
    void SearchMatrix(int[][] matrix, int target, boolean actual) {
        solution = new Solution3();
        boolean result = solution.searchMatrix(matrix, target);
        assertThat(result).isEqualTo(actual);
    }

    /**
     * @return
     */
    static Stream<Arguments> searchMatrixProvider() {
        return Stream.of(
                Arguments.arguments(generate(), 5, true),
                Arguments.arguments(generate(), 20, false)
        );
    }

    private static int[][] generate() {
        return new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
    }
}