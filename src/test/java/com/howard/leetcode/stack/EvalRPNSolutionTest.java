package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("逆波兰表达式")
class EvalRPNSolutionTest {

    private EvalRPNSolution solution;

    @BeforeEach
    void setUp() {
        solution = new EvalRPNSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试逆波兰表达式值")
    void evalRPN(String[] tokens, int rightValue) {
        int result = solution.evalRPN(tokens);
        Assertions.assertThat(result).as("正确的值").isEqualTo(rightValue);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.arguments(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.arguments(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }
}