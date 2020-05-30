package com.howard.leetcode.eighteen.arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution350Test {

    private Solution350 solution;

    @ParameterizedTest
    @MethodSource("intersectProvider")
    @DisplayName("Intersect")
    void Intersect(int[] nums1, int[] nums2, int[] right) {
        solution = new Solution350();
        int[] result = solution.intersect(nums1, nums2);
        assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> intersectProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1,2,2,1}, new int[] {2,2}, new int[] {2,2}),
                Arguments.arguments(new int[] {4,9,5}, new int[] {9,4,9,8,4}, new int[] {4,9})
        );
    }
}