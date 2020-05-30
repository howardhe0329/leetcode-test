package com.howard.leetcode.eighteen.stacks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution378Test {

    private Solution378 solution;

    @ParameterizedTest
    @MethodSource("kthSmallestProvider")
    @DisplayName("KthSmallest")
    void KthSmallest(int[][] matrix, int k, int right) {
        solution = new Solution378();
        int result = solution.kthSmallest(matrix, k);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> kthSmallestProvider() {
        return Stream.of(
                Arguments.arguments(new int[][] {
                        new int[]{1, 5, 9},
                        new int[] {10, 11, 13},
                        new int[] {12, 13, 15}
                },8, 13),
                Arguments.arguments(new int[][] {
                        new int[]{1, 5, 9},
                        new int[] {10, 11, 13},
                        new int[] {12, 13, 15}
                }, 1, 1),
                Arguments.arguments(new int[][] {
                        new int[]{1, 5, 9},
                        new int[] {10, 11, 13},
                        new int[] {12, 13, 15}
                }, 2, 5),
                Arguments.arguments(new int[][] {new int[] {-5}
                },1, -5),
                Arguments.arguments(new int[][] {new int[] {1, 2},new int[] {3, 3}
                },4, 3)
        );
    }
}