package com.howard.leetcode.graph.search;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution200Test {

    private Solution200 solution;

    @ParameterizedTest
    @MethodSource("numIslandsProvider")
    @DisplayName("NumIslands")
    void NumIslands(char[][] grid, int right) {
        solution = new Solution200();
        int result = solution.numIslands(grid);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> numIslandsProvider() {
        return Stream.of(
                Arguments.arguments(new char[][] {
                        new char[] {'1', '1', '1', '1', '0'},
                        new char[] {'1', '1', '0', '1', '0'},
                        new char[] {'1', '1', '0', '0', '0'},
                        new char[] {'0', '0', '0', '0', '0'}
                }, 1),
                Arguments.arguments(new char[][] {
                        new char[] {'1', '1', '0', '0', '0'},
                        new char[] {'1', '1', '0', '0', '0'},
                        new char[] {'0', '0', '1', '0', '0'},
                        new char[] {'0', '0', '0', '1', '1'}
                }, 3)
        );
    }
}