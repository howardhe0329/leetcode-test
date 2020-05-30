package com.howard.leetcode.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution205Test {

    private Solution205 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution205();
    }

    @ParameterizedTest
    @MethodSource("IsIsomorphicProvider")
    @DisplayName("IsIsomorphic")
    void IsIsomorphic(String s, String t, boolean target) {
        boolean result = solution.isIsomorphic(s, t);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> IsIsomorphicProvider() {
        return Stream.of(
                Arguments.arguments("egg", "add", true),
                Arguments.arguments("foo", "bar", false),
                Arguments.arguments("paper", "title", true)
        );
    }
}