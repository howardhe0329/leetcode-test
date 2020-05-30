package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("旋转有序数组最大值和最小值")
class RotateSortedArraySearchTest {

    private RotateSortedArraySearch search;

    @BeforeEach
    void setUp() {
        search = new RotateSortedArraySearch();
    }

    @ParameterizedTest
    @MethodSource("providerMin")
    void findMin(int[] nums, int min) {
        int result = search.findMin(nums);
        Assertions.assertThat(result).isEqualTo(min);
    }

    @ParameterizedTest
    @MethodSource("providerMax")
    void findMax(int[] nums, int max) {
        int result = search.findMax(nums);
        Assertions.assertThat(result).isEqualTo(max);
    }

    static Stream<Arguments> providerMin() {
        return Stream.of(
                Arguments.arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)
        );
    }

    static Stream<Arguments> providerMax() {
        return Stream.of(
                Arguments.arguments(new int[] {4, 5, 6, 7, 0, 1, 2}, 7)
        );
    }
}