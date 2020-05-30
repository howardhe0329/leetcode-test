package com.howard.leetcode.eighteen.arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution238Test {

    private Solution238 solution;

    @ParameterizedTest
    @MethodSource("productExceptSelfProvider")
    @DisplayName("ProductExceptSelf")
    void ProductExceptSelf(int[] nums, int[] right) {
        solution = new Solution238();
        int[] result = solution.productExceptSelf(nums);
        assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> productExceptSelfProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3, 4}, new int[] {24,12,8,6})
        );
    }
}