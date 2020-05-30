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

@DisplayName("寻找峰值")
class FindPeakElementSolutionTest {

    private FindPeakElementSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindPeakElementSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试寻找峰值")
    void findPeakElement(int[] nums, int right) {
        int result = solution.findPeakElement(nums);
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[] {1,2,3,1}, 2),
                Arguments.arguments(new int[] {1,2,1,3,5,6,4}, 5),
                Arguments.arguments(new int[] {1,2}, 1)
        );
    }
}