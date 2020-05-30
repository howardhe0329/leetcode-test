package com.howard.leetcode.bytedance.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution567Test {

    private Solution567 solution;

    @ParameterizedTest
    @MethodSource("checkInclusionProvider")
    @DisplayName("CheckInclusion")
    void CheckInclusion(String s1, String s2, boolean right) {
        solution = new Solution567();
        boolean result = solution.checkInclusion(s1, s2);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> checkInclusionProvider() {
        return Stream.of(
                Arguments.arguments("ab", "eidbaooo", true),
                Arguments.arguments("ab", "eidboaoo", false)
        );
    }
}