package com.howard.leetcode.binary.tree.heap;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("堆")
class HeapTest {

    private Heap heap;

    @ParameterizedTest
    @MethodSource("providerInsert")
    @DisplayName("插入一个元素")
    void insert(List<Integer> data, Object[] rightArray) {
        heap = new Heap(data.size(), Comparator.reverseOrder());
        data.forEach(item -> heap.insert(item));
        Assertions.assertThat(heap.items()).containsSequence(rightArray);
    }

    static Stream<Arguments> providerInsert() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(8, 4, 2, 5, 6, 1, 11),
                        new Object[] {11, 6, 8, 4, 5, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("providerDelete")
    @DisplayName("删除堆顶元素")
    void deleteTop(List<Integer> data, Object[] rightArray) {
        heap = new Heap(data.size(), Comparator.reverseOrder());
        data.forEach(item -> heap.insert(item));
        heap.removeTop();
        int size = heap.size();
        Assertions.assertThat(size).isEqualTo(data.size() - 1);
        Assertions.assertThat(heap.items()).containsSequence(rightArray);
    }

    static Stream<Arguments> providerDelete() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(8, 4, 2, 5, 6, 1, 11),
                        new Object[] {8, 6, 2, 4, 5, 1})
        );
    }
}