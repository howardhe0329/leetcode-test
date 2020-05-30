package com.howard.leetcode.array;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution121Test {

    private Solution121 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution121();
    }

    @ParameterizedTest
    @MethodSource("maxProfitProvider")
    @DisplayName("MaxProfit")
    void MaxProfit(int[] prices, int maxProfit) {
        int result = solution.maxProfit(prices);
        assertThat(result).isEqualTo(maxProfit);
    }

    static Stream<Arguments> maxProfitProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {7,1,5,3,6,4}, 5),
                Arguments.arguments(new int[] {7,6,4,3,1}, 0)
        );
    }
}