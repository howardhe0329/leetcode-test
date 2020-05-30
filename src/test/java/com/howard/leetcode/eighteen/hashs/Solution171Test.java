package com.howard.leetcode.eighteen.hashs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution171Test {

    private Solution171 solution;

    @ParameterizedTest
    @MethodSource("titleToNumberProvider")
    @DisplayName("TitleToNumber")
    void TitleToNumber(String s, int right) {
        solution = new Solution171();
        int result = solution.titleToNumber(s);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> titleToNumberProvider() {
        return Stream.of(
                Arguments.arguments("A", 1),
                Arguments.arguments("B", 2),
                Arguments.arguments("C", 3),
                Arguments.arguments("AB", 28),
                Arguments.arguments("ZY", 701)
        );
    }
}