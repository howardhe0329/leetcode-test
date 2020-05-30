package com.howard.leetcode.bytedance.strings;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution151Test {

    private Solution151 solution;

    @ParameterizedTest
    @MethodSource("reverseWordsProvider")
    @DisplayName("ReverseWords")
    void ReverseWords(String s, String out) {
        solution = new Solution151();
        String result = solution.reverseWords(s);
        assertThat(result).isEqualTo(out);
    }

    static Stream<Arguments> reverseWordsProvider() {
        return Stream.of(
                Arguments.arguments("the sky is blue", "blue is sky the"),
                Arguments.arguments("  hello world!  ", "world! hello"),
                Arguments.arguments("a good   example", "example good a")
        );
    }
}