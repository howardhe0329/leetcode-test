package com.howard.leetcode.math;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution202Test {

    private Solution202 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution202();
    }

    @ParameterizedTest
    @MethodSource("IsHappyProvider")
    @DisplayName("IsHappy")
    void IsHappy(int num, boolean target) {
        boolean result = solution.isHappy(num);
        Assertions.assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> IsHappyProvider() {
        return Stream.of(
                Arguments.arguments(19, true),
                Arguments.arguments(18, false),
                Arguments.arguments(0, false),
                Arguments.arguments(Integer.MAX_VALUE, false)
        );
    }
}