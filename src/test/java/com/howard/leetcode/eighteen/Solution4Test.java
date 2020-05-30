package com.howard.leetcode.eighteen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("合并两个有序数组")
class Solution4Test {

    private Solution4 solution;

    @ParameterizedTest
    @MethodSource("mergeProvider")
    @DisplayName("Merge")
    void Merge(int[] nums1, int m, int[] nums2, int n, int[] target) {
        solution = new Solution4();
        solution.merge(nums1, m, nums2, n);
        assertThat(nums1).containsSequence(target);
    }

    static Stream<Arguments> mergeProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6})
        );
    }
}