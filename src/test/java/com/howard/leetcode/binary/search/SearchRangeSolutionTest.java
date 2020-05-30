package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("在排序数组中查找元素的第一个和最后一个位置")
class SearchRangeSolutionTest {

    private SearchRangeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SearchRangeSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试")
    void searchRange(int[] nums, int target, int[] right) {
        int[] result = solution.searchRange(nums, target);
        Assertions.assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1})
        );
    }
}