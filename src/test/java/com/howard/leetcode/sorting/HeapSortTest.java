package com.howard.leetcode.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("堆排序")
class HeapSortTest {

    private HeapSort sort;

    @BeforeEach
    void setUp() {
        sort = new HeapSort();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("堆排序")
    void sort(int[] data, int[] sorted) {
        int[] result = sort.sort(data);
        Assertions.assertThat(result).containsSequence(sorted);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[] {8, 10, 7, 6, 3, 5, 1, 13, 22},
                        new int[] {1, 3, 5, 6, 7, 8, 10, 13, 22})
        );
    }
}