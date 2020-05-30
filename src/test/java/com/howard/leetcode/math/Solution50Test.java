package com.howard.leetcode.math;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("x的n次幂")
class Solution50Test {

    private Solution50 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution50();
    }

    @ParameterizedTest
    @MethodSource("myPowProvider")
    @DisplayName("MyPow")
    void MyPow(double x, int n, double target) {
        double result = solution.myPow(x, n);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> myPowProvider() {
        return Stream.of(
                Arguments.arguments(2, 0, 1),
                Arguments.arguments(2, 1, 2),
                Arguments.arguments(2, 2, 4),
                Arguments.arguments(2, -1, 0.5),
                Arguments.arguments(2, -2, 1.0d / 4),
                Arguments.arguments(2.00000, 10, 1024.00000),
                Arguments.arguments(2.10000, 3, 9.26100)
        );
    }
}