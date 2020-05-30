package com.howard.leetcode.eighteen.stacks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("查找数据流中的中位数")
class MedianFinderTest {

    private MedianFinder finder;

    @ParameterizedTest
    @MethodSource("addNumProvider")
    @DisplayName("AddNum")
    void AddNum(int[] list) {
        finder = new MedianFinder();
        for (int i = 0; i < list.length; i++) {
            finder.addNum(list[i]);
        }
        Assertions.assertThat(finder.getMaxHeap().size()).isEqualTo(2);
        Assertions.assertThat(finder.getMinHeap().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("findMedianProvider")
    @DisplayName("FindMedian")
    void FindMedian(int[] list, double right) {
        finder = new MedianFinder();
        for (int i = 0; i < list.length; i++) {
            finder.addNum(list[i]);
        }
        double median = finder.findMedian();
        Assertions.assertThat(median).isEqualTo(right);
    }

    static Stream<Arguments> addNumProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3})
        );
    }

    static Stream<Arguments> findMedianProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3}, 2)
        );
    }
}