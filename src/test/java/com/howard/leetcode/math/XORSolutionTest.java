package com.howard.leetcode.math;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class XORSolutionTest {

    private XORSolution solution;

    @BeforeEach
    void setUp() {
        solution = new XORSolution();
    }

    @ParameterizedTest
    @MethodSource("swapProvider")
    @DisplayName("Swap")
    void Swap(int[] nums, int x, int y, int[] target) {
        solution.swap(nums, x, y);
        assertThat(nums).isEqualTo(target);
    }

    static Stream<Arguments> swapProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2}, 0, 1, new int[] {2, 1}),
                Arguments.arguments(new int[] {11, 18}, 0, 1, new int[] {18, 11})
        );
    }
}