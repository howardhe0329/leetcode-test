package com.howard.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class Solution350_1Test {

    private Solution350_1 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution350_1();
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
                Arguments.arguments(new int[] {1,2,2,1}, new int[] {2, 2}, new int[] {2, 2}),
                Arguments.arguments(null, null, new int[] {})
        );
    }
}
