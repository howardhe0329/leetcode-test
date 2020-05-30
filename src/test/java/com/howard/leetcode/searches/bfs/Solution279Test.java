package com.howard.leetcode.searches.bfs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution279Test {

    private Solution279 solution;

    @ParameterizedTest
    @MethodSource("numSquaresProvider")
    @DisplayName("NumSquares")
    void NumSquares(int n, int rigth) {
        solution = new Solution279();
        int result = solution.numSquares(n);
        assertThat(result).isEqualTo(rigth);
    }

    static Stream<Arguments> numSquaresProvider() {
        return Stream.of(
                Arguments.arguments(12, 3),
                Arguments.arguments(13, 2)
        );
    }
}