package com.howard.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution217Test {

    private Solution217 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution217();
    }

    @ParameterizedTest
    @MethodSource("ContainsDuplicateProvider")
    @DisplayName("ContainsDuplicate")
    void ContainsDuplicate(int[] nums, boolean target) {
        boolean result = solution.containsDuplicate(nums);
        Assertions.assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> ContainsDuplicateProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3, 1}, true),
                Arguments.arguments(new int[] {1, 2, 3, 4}, false)
        );
    }
}