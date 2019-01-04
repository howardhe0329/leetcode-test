package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("验证字符是否有效的括号")
class IsValidBracketsSolutionTest {

    private IsValidBracketsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsValidBracketsSolution();
    }

    @ParameterizedTest
    @MethodSource("providerIsTrue")
    @DisplayName("验证有效的括号, 测试为true")
    void isValidIsTrue(String s) {
        boolean result = solution.isValid(s);
        Assertions.assertThat(result).as("有效的括号").isTrue();
    }

    @ParameterizedTest
    @MethodSource("providerIsFalse")
    @DisplayName("验证有效的括号, 测试为false")
    void isValidIsFalse(String s) {
        boolean result = solution.isValid(s);
        Assertions.assertThat(result).as("无效的括号").isFalse();
    }

    static Stream<Arguments> providerIsTrue() {
        return Stream.of(
                Arguments.arguments(""),
                Arguments.arguments("()"),
                Arguments.arguments("{}"),
                Arguments.arguments("[]"),
                Arguments.arguments("[()]"),
                Arguments.arguments("[({})]")
        );
    }

    static Stream<Arguments> providerIsFalse() {
        return Stream.of(
                Arguments.arguments("([]"),
                Arguments.arguments("("),
                Arguments.arguments("["),
                Arguments.arguments("]"),
                Arguments.arguments("{"),
                Arguments.arguments("{]"),
                Arguments.arguments("{}[(]"),
                Arguments.arguments("{}[()")
        );
    }
}