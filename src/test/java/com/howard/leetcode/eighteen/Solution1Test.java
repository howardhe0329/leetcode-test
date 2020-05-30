package com.howard.leetcode.eighteen;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution1Test {

    private Solution1 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution1();
    }

    @ParameterizedTest
    @MethodSource("singleNumberProvider")
    @DisplayName("SingleNumber")
    void SingleNumber(int[] nums, int target) {
        int result = solution.singleNumber(nums);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> singleNumberProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {2,2,1}, 1),
                Arguments.arguments(new int[] {4,1,2,1,2}, 4)
        );
    }
}