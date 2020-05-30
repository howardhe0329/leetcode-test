package com.howard.leetcode.bytedance.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution14Test {

    private Solution14 solution;

    @ParameterizedTest
    @MethodSource("longestCommonPrefixProvider")
    @DisplayName("LongestCommonPrefix")
    void LongestCommonPrefix(String[] strs, String right) {
        solution = new Solution14();
        String result = solution.longestCommonPrefix(strs);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> longestCommonPrefixProvider() {
        return Stream.of(
                Arguments.arguments(new String[] {"flower","flow","flight"}, "fl"),
                Arguments.arguments(new String[] {"dog","racecar","car"}, "")
        );
    }
}