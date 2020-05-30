package com.howard.leetcode.eighteen.arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution384Test {

    private Solution384 solution;

    @ParameterizedTest
    @MethodSource("resetProvider")
    @DisplayName("Reset")
    void Reset(int[] nums) {
        solution = new Solution384(nums);
        int[] result = solution.reset();
        assertThat(result).isNotEmpty().containsSequence(nums);

    }

    @ParameterizedTest
    @MethodSource("shuffleProvider")
    @DisplayName("Shuffle")
    void Shuffle(int[] nums) {
        solution = new Solution384(nums);
        int[] result = solution.shuffle();
        assertThat(result).isNotEmpty().contains(nums);
    }

    static Stream<Arguments> shuffleProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3}),
                Arguments.arguments(new int[] {1, 2, 3, 4})
        );
    }

    static Stream<Arguments> resetProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3}),
                Arguments.arguments(new int[] {1, 2, 3, 4})
        );
    }
}