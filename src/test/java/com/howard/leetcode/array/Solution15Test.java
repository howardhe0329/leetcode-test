package com.howard.leetcode.array;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("三数之和")
class Solution15Test {

    private Solution15 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution15();
    }

    @ParameterizedTest
    @MethodSource("threeSumProvider")
    @DisplayName("ThreeSum")
    void threeSum(int[] nums, List<List<Integer>> target) {
        List<List<Integer>> result = solution.threeSum(nums);
        assertThat(result).containsSequence(target);
    }

    static Stream<Arguments> threeSumProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{-1, 0, 1, 2, -1, -4}, Lists.newArrayList(Lists.newArrayList(-1, -1, 2), Lists.newArrayList(-1, 0, 1))),
                Arguments.arguments(new int[] {}, Lists.newArrayList())
        );
    }

    @ParameterizedTest
    @MethodSource("threeSum1Provider")
    @DisplayName("Name")
    void threeSum1(int[] nums, List<List<Integer>> target) {
        List<List<Integer>> result = solution.threeSum1(nums);
        assertThat(result).containsSequence(target);
    }

    static Stream<Arguments> threeSum1Provider() {
        return Stream.of(
                Arguments.arguments(new int[]{-1, 0, 1, 2, -1, -4}, Lists.newArrayList(Lists.newArrayList(-1, 0, 1), Lists.newArrayList(-1, -1, 2))),
                Arguments.arguments(new int[] {}, Lists.newArrayList())
        );
    }
}