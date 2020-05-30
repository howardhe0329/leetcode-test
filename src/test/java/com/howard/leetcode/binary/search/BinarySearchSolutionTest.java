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

@DisplayName("二分查找算法")
class BinarySearchSolutionTest {

    private BinarySearchSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BinarySearchSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("二分查找")
    void search(int[] nums, int target, int rightIndex) {
        int result = solution.search(nums, target);
        Assertions.assertThat(result).isEqualTo(rightIndex);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[] {-1,0,3,5,9,12}, 9, 4),
                Arguments.arguments(new int[] {-1,0,3,5,9,12}, 2, -1)
        );
    }

}