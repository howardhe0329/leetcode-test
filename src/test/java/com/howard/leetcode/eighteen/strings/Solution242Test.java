package com.howard.leetcode.eighteen.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution242Test {

    private Solution242 solution;

    @ParameterizedTest
    @MethodSource("isAnagramProvider")
    @DisplayName("IsAnagram")
    void IsAnagram(String s, String t, boolean right) {
        solution = new Solution242();
        boolean result = solution.isAnagram(s, t);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> isAnagramProvider() {
        return Stream.of(
                Arguments.arguments("anagram", "nagaram", true),
                Arguments.arguments("rat", "car", false)
        );
    }
}