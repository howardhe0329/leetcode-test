package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("搜索旋转排序数组")
class RotateSortedArraySolutionTest {

    private RotateSortedArraySolution solution;

    @BeforeEach
    void setUp() {
        solution = new RotateSortedArraySolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试搜索旋转排序数组")
    void search(int[] nums, int target, int right) {
        int result = solution.search(nums, target);
        Assertions.assertThat(result).isEqualTo(right);
    }


    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 1, 5),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 5, 1),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 6, 2),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 7, 3),
                Arguments.arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.arguments(new int[]{4, 5, 6, 7, 8, 9, 10, 0, 1, 2}, 9, 5)
        );
    }
}