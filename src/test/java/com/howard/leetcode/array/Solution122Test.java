package com.howard.leetcode.array;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution122Test {

    private Solution122 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution122();
    }

    @ParameterizedTest
    @MethodSource("maxProfitProvider")
    @DisplayName("MaxProfit")
    void MaxProfit(int[] nums, int profit) {
        int result = solution.maxProfit(nums);
        assertThat(result).isEqualTo(profit);
    }

    static Stream<Arguments> maxProfitProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {7,1,5,3,6,4}, 7),
                Arguments.arguments(new int[] {1,2,3,4,5}, 4)
        );
    }
}