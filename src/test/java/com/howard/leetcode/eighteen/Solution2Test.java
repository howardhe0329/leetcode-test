package com.howard.leetcode.eighteen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution2Test {

    private Solution2 solution;

    @ParameterizedTest
    @MethodSource("majorityElementProvider")
    @DisplayName("MajorityElement")
    void MajorityElement(int[] nums, int target) {
        solution = new Solution2();
        int result = solution.majorityElement(nums);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> majorityElementProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {3, 2, 3}, 3),
                Arguments.arguments(new int[] {2,2,1,1,1,2,2}, 2)
        );
    }
}