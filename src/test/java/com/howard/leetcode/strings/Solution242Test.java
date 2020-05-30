package com.howard.leetcode.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution242Test {

    private Solution242 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution242();
    }

    @ParameterizedTest
    @MethodSource("IsAnagramProvider")
    @DisplayName("IsAnagram")
    void IsAnagram(String s, String t, boolean target) {
        boolean result = solution.isAnagram(s, t);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> IsAnagramProvider() {
        return Stream.of(
                Arguments.arguments("anagram", "nagaram", true),
                Arguments.arguments("rat", "car", false)
        );
    }
}