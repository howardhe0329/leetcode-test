package com.howard.leetcode.array;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution350_2Test {

    private Solution350_2 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution350_2();
    }

    @ParameterizedTest
    @MethodSource("IntersectProvider")
    @DisplayName("Intersect")
    void Intersect(int[] nums1, int[] nums2, int[] target) {
        int[] result = solution.intersect(nums1, nums2);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> IntersectProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {4,5,9}, new int[] {4,4,8,9, 9}, new int[] {4, 9}),
                Arguments.arguments(new int[] {4,4,8,9, 9}, new int[] {4,5,9}, new int[] {4, 9}),
                Arguments.arguments(new int[] {1,1, 2, 2}, new int[] {2, 2}, new int[] {2, 2}),
                Arguments.arguments(new int[] {2, 2}, new int[] {1,1, 2, 2}, new int[] {2, 2})
        );
    }
}