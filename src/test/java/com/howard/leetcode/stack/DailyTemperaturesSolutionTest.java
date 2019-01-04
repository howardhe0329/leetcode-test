package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("每日温度")
class DailyTemperaturesSolutionTest {

    private DailyTemperaturesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DailyTemperaturesSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试每日温度")
    void dailyTemperatures(int[] data, int[] rightResult) {
        int[] result = solution.dailyTemperatures(data);
        Assertions.assertThat(result).as("正确").isIn(rightResult);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{73, 74, 75, 71, 69, 72, 76, 73}
                , new int[] {1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.arguments(new int[]{73, 74, 75, 71}
                        , new int[] {1, 1, 0, 0}),
                Arguments.arguments(new int[]{73, 72, 71, 66}
                        , new int[] {0, 0, 0, 0}),
                Arguments.arguments(new int[]{73, 72, 71, 75}
                        , new int[] {3, 2, 1, 0})
        );
    }
}