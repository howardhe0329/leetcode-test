package com.howard.leetcode.eighteen.stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution227Test {

    private Solution227 solution;

    @ParameterizedTest
    @MethodSource("calculateProvider")
    @DisplayName("Calculate")
    void Calculate(String s, int right) {
        solution = new Solution227();
        int result = solution.calculate(s);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> calculateProvider() {
        return Stream.of(
                Arguments.arguments("3+2*2", 7),
                Arguments.arguments(" 3/2 ", 1),
                Arguments.arguments(" 3+5 / 2 ", 5),
                Arguments.arguments("0-0", 0),
                Arguments.arguments("42", 42),
                Arguments.arguments("1-1+1", 1)
        );
    }
}