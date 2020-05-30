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

@DisplayName("四数之和")
class Solution18Test {

    private Solution18 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution18();
    }

    @ParameterizedTest
    @MethodSource("fourSumProvider")
    @DisplayName("FourSum")
    void FourSum(int[] nums, int target, List<List<Integer>> actual) {
        List<List<Integer>> result = solution.fourSum(nums, target);
        assertThat(result).containsSequence(actual);
    }

    static Stream<Arguments> fourSumProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 0, -1, 0, -2, 2}, 0, Lists.newArrayList(Lists.newArrayList(-1, 0, 0, 1),
                        Lists.newArrayList(-2, -1, 1, 2),
                        Lists.newArrayList(-2, 0, 0, 2))),
                Arguments.arguments(new int[]{}, 0, Lists.newArrayList())
        );
    }
}