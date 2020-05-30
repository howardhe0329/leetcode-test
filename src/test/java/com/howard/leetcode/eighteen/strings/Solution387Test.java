package com.howard.leetcode.eighteen.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution387Test {

    private Solution387 solution;

    @ParameterizedTest
    @MethodSource("firstUniqCharProvider")
    @DisplayName("FirstUniqChar")
    void FirstUniqChar(String s, int right) {
        solution = new Solution387();
        int result = solution.firstUniqChar(s);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> firstUniqCharProvider() {
        return Stream.of(
                Arguments.arguments("leetcode", 0),
                Arguments.arguments("loveleetcode", 2),
                Arguments.arguments("ooee", -1)
        );
    }
}