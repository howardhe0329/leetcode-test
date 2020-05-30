package com.howard.leetcode.eighteen.arrays;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution217Test {

    private Solution217 solution;

    @ParameterizedTest
    @MethodSource("containsDuplicateProvider")
    @DisplayName("ContainsDuplicate")
    void ContainsDuplicate(int[] nums, boolean right) {
        solution = new Solution217();
        boolean result = solution.containsDuplicate(nums);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> containsDuplicateProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1,2,3,1}, true),
                Arguments.arguments(new int[] {1,2,3,4}, false)
        );
    }
}