package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("寻找旋转排序数组中的最小值")
class RotateSortedArrayMinSolutionTest {

    private RotateSortedArrayMinSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RotateSortedArrayMinSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试寻找旋转排序数组中的最小值")
    void findMin(int[] nums, int min) {
        int result = solution.findMin(nums);
        Assertions.assertThat(result).isEqualTo(min);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[] {3,4,5,1,2}, 1),
                Arguments.arguments(new int[] {4,5,6,7,0,1,2}, 0)
        );
    }

}