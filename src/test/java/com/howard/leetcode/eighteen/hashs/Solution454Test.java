package com.howard.leetcode.eighteen.hashs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution454Test {

    private Solution454 solution;

    @ParameterizedTest
    @MethodSource("fourSumCountProvider")
    @DisplayName("FourSumCount")
    void FourSumCount(int[] A, int[] B, int[] C, int[] D, int right) {
        solution = new Solution454();
        int result = solution.fourSumCount(A, B, C, D);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> fourSumCountProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
                Arguments.arguments(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}, 6)
        );
    }
}