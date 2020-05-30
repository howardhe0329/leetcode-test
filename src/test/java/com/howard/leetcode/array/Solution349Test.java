package com.howard.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("两个数组相交")
class Solution349Test {

    private Solution349 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution349();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("两个数组相交测试")
    void intersection(int[] nums1, int[] nums2, int[] target) {
        int[] result = solution.intersection(nums1, nums2);
        Assertions.assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(null, null, new int[0]),
                Arguments.arguments(new int[] {1}, new int[] {2}, new int[0]),
                Arguments.arguments(new int[] {1, 2}, new int[] {2}, new int[] {2}),
                Arguments.arguments(new int[] {1, 2, 2, 3, 4, 5, 5, 5, 7}, new int[] {2, 5, 5, 8, 9, 10, 10}, new int[] {2, 5})
        );
    }

}