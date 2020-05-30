package com.howard.leetcode.eighteen.stacks;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("逆波兰表达式")
class Solution150Test {

    private Solution150 solution;

    @ParameterizedTest
    @MethodSource("evalRPNProvider")
    @DisplayName("EvalRPN")
    void EvalRPN(String[] tokens, int right) {
        solution = new Solution150();
        int result = solution.evalRPN(tokens);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> evalRPNProvider() {
        return Stream.of(
                Arguments.arguments(new String[] {"2", "1", "+", "3", "*"}, 9),
                Arguments.arguments(new String[] {"4", "13", "5", "/", "+"}, 6),
                Arguments.arguments(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }
}