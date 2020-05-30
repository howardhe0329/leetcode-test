package com.howard.leetcode.eighteen.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution189Test {

    private Solution189 solution;

    @ParameterizedTest
    @MethodSource("rotateProvider")
    @DisplayName("Rotate")
    void Rotate(int[] nums, int k, int[] rights) {
        solution = new Solution189();
        solution.rotate(nums, k);
        assertThat(nums).containsSequence(rights);
    }

    static Stream<Arguments> rotateProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, new int[]{7, 1, 2, 3, 4, 5, 6}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{6, 7, 1, 2, 3, 4, 5}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, new int[]{4, 5, 6, 7, 1, 2, 3}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, new int[]{3, 4, 5, 6, 7, 1, 2}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 11, new int[]{4, 5, 6, 7, 1, 2, 3}),
                Arguments.arguments(new int[]{-1, -100, 3, 99}, 1, new int[]{99, -1, -100, 3}),
                Arguments.arguments(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}),
                Arguments.arguments(new int[]{-1, -100, 3, 99}, 3, new int[]{-100, 3, 99, -1}),
                Arguments.arguments(new int[]{-1, -100, 3, 99}, 6, new int[]{3, 99, -1, -100}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 1, new int[]{6, 1, 2, 3, 4, 5}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{5, 6, 1, 2, 3, 4}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{4, 5, 6, 1, 2, 3}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 4, new int[]{3, 4, 5, 6, 1, 2}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 5, new int[]{2, 3, 4, 5, 6, 1})
        );
    }
}