package com.howard.leetcode.eighteen.maths;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution166Test {

    private Solution166 solution;

    @ParameterizedTest
    @MethodSource("fractionToDecimalProvider")
    @DisplayName("FractionToDecimal")
    void FractionToDecimal(int numerator, int denominator, String right) {
        solution = new Solution166();
        String result = solution.fractionToDecimal(numerator,denominator);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> fractionToDecimalProvider() {
        return Stream.of(
                Arguments.arguments(1, 2, "0.5"),
                Arguments.arguments(2, 1, "2"),
                Arguments.arguments(2, 3, "0.(6)")
        );
    }
}