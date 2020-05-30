package com.howard.leetcode.graph.search;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution547Test {

    private Solution547 solution;

    @ParameterizedTest
    @MethodSource("findCircleNumProvider")
    @DisplayName("FindCircleNum")
    void FindCircleNum(int[][] M, int right) {
        solution = new Solution547();
        int result = solution.findCircleNum(M);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> findCircleNumProvider() {
        return Stream.of(
                Arguments.arguments(new int[][] {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }, 2),
                Arguments.arguments(new int[][] {
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}
                }, 1)
        );
    }
}