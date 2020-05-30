package com.howard.leetcode.eighteen.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("反转字符串")
class Solution344Test {

    private Solution344 solution;

    @ParameterizedTest
    @MethodSource("reverseStringProvider")
    @DisplayName("ReverseString")
    void ReverseString(char[] s, char[] right) {
        solution = new Solution344();
        solution.reverseString(s);
        assertThat(s).containsSequence(right);
    }

    static Stream<Arguments> reverseStringProvider() {
        return Stream.of(
                Arguments.arguments("hello".toCharArray(), "olleh".toCharArray()),
                Arguments.arguments("Hannah".toCharArray(), "hannaH".toCharArray())
        );
    }
}