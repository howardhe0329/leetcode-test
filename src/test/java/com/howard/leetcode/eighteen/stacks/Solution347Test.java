package com.howard.leetcode.eighteen.stacks;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("")
class Solution347Test {

    private Solution347 solution;

    @ParameterizedTest
    @MethodSource("topKFrequentProvider")
    @DisplayName("TopKFrequent")
    void TopKFrequent(int[] nums, int k, List<Integer> right) {
        solution = new Solution347();
        List<Integer> result = solution.topKFrequent(nums, k);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> topKFrequentProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1,1,1,2,2,3}, 2, Lists.newArrayList(1, 2)),
                Arguments.arguments(new int[] {1}, 1, Lists.newArrayList(1))
        );
    }
}