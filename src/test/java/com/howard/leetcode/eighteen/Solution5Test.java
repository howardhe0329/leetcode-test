package com.howard.leetcode.eighteen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution5Test {

    private Solution5 solution;

    @ParameterizedTest
    @MethodSource("superEggDropProvider")
    @DisplayName("SuperEggDrop")
    void SuperEggDrop(int k, int n, int target) {
        solution = new Solution5();
        int result = solution.superEggDrop(k, n);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> superEggDropProvider() {
        return Stream.of(
                Arguments.arguments(1, 2, 2),
                Arguments.arguments(2, 6, 3),
                Arguments.arguments(3, 14, 4),
                Arguments.arguments(2, 100, 14)
        );
    }
}