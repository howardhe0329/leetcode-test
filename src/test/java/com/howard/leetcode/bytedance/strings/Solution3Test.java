package com.howard.leetcode.bytedance.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution3Test {

    private Solution3 solution;

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringProvider")
    @DisplayName("LengthOfLongestSubstring")
    void LengthOfLongestSubstring(String s, int right) {
        solution = new Solution3();
        int result = solution.lengthOfLongestSubstring(s);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> lengthOfLongestSubstringProvider() {
        return Stream.of(
                Arguments.arguments("abcabcbb", 3),
                Arguments.arguments("bbbbb", 1),
                Arguments.arguments("pwwkew", 3),
                Arguments.arguments(" ", 1),
                Arguments.arguments("aab", 2),
                Arguments.arguments("dvdf", 3)
        );
    }
}