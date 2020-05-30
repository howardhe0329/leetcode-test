package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("求x的平方根")
class MySqrtIntegerSolutionTest {

    private MySqrtIntegerSolution solution;

    @BeforeEach
    public void setUp() {
        solution = new MySqrtIntegerSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("求x的平方根")
    void mySqrt(int x, int right) {
        int result = solution.mySqrt(x);
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(4, 2),
                Arguments.arguments(8, 2)
        );
    }
}