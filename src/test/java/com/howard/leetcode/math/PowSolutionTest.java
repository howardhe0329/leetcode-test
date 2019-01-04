package com.howard.leetcode.math;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("pow")
class PowSolutionTest {

    private PowSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PowSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试pow(x, n)")
    void myPow(double x, int n, double right) {
        double result = solution.myPow(x, n);
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(2.00000, 10, 1024.00000),
//                Arguments.arguments(2.10000, 3, 9.26100),
                Arguments.arguments(2.00000, -2, 0.25000)
        );
    }
}