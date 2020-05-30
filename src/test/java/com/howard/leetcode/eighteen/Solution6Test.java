package com.howard.leetcode.eighteen;

import static org.assertj.core.api.Assertions.*;

import com.howard.leetcode.eighteen.strings.Solution6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution6Test {

    private Solution6 solution;

    @ParameterizedTest
    @MethodSource("isPalindromeProvider")
    @DisplayName("IsPalindrome")
    void IsPalindrome(String s, boolean target) {
        solution = new Solution6();
        boolean result = solution.isPalindrome(s);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> isPalindromeProvider() {
        return Stream.of(
                Arguments.arguments("A man, a plan, a canal: Panama", true),
                Arguments.arguments("race a car", false)
        );
    }
}