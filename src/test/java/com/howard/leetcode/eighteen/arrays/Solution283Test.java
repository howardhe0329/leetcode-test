package com.howard.leetcode.eighteen.arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution283Test {

    private Solution283 solution;

    @ParameterizedTest
    @MethodSource("moveZeroesProvider")
    @DisplayName("MoveZeroes")
    void MoveZeroes(int[] nums, int[] right) {
        solution = new Solution283();
        solution.moveZeroes(nums);
        assertThat(nums).containsSequence(right);
    }

    static Stream<Arguments> moveZeroesProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {0,1,0,3,12}, new int[] {1,3,12, 0, 0})
        );
    }
}