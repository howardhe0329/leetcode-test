package com.howard.leetcode.sorting;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("归并排序算法")
class MergeSortTest {

    private MergeSort sort;

    @BeforeEach
    void setUp() {
        sort = new MergeSort();
    }

    @ParameterizedTest
    @MethodSource("sortProvider")
    @DisplayName("Sort")
    void sort() {
    }

}