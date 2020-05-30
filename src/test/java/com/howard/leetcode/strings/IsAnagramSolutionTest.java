package com.howard.leetcode.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("是否为异位词")
class IsAnagramSolutionTest {

    private IsAnagramSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsAnagramSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试是否为异位词")
    void isAnagram(String s, String t, boolean right) {
        boolean result = solution.isAnagram(s, t);
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments("anagram", "nagaram", true),
                Arguments.arguments("rat", "car", false)
        );
    }
}