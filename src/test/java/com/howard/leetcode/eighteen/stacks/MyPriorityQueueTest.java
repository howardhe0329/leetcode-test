package com.howard.leetcode.eighteen.stacks;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MyPriorityQueueTest {

    private MyPriorityQueue queue;

    @ParameterizedTest
    @MethodSource("offerProvider")
    @DisplayName("Offer")
    void Offer(List<Integer> list, int min) {
        queue = new MyPriorityQueue(list.size());
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
            assertThat(queue.size()).isEqualTo(i + 1);
        }
        assertThat(queue.poll()).isNotNull().isEqualTo(min);
    }

    static Stream<Arguments> offerProvider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(14, 4, 25, 19, 33, 5, 28, 2), 2),
                Arguments.arguments(Lists.newArrayList(2, 3, 4, 5, 9, 10, 7, 6, 8), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("pollProvider")
    @DisplayName("Poll")
    void Poll(List<Integer> list, List<Integer> right) {
        queue = new MyPriorityQueue(list, 20);
        for (int n: right) {
            Object result = queue.poll();
            assertThat(result).isEqualTo(n);
        }
    }

    static Stream<Arguments> pollProvider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(14, 4, 25, 19, 33, 5, 28, 2),
                        Lists.newArrayList(2, 4, 5, 14, 19, 25, 28, 33)),
                Arguments.arguments(Lists.newArrayList(2, 3, 4, 5, 9, 10, 7, 6, 8),
                        Lists.newArrayList(2, 3, 4, 5, 6, 7, 8, 9, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("PeekProvider")
    @DisplayName("Peek")
    void Peek() {
    }

    @ParameterizedTest
    @MethodSource("SizeProvider")
    @DisplayName("Size")
    void Size() {
    }

    @ParameterizedTest
    @MethodSource("IsEmptyProvider")
    @DisplayName("IsEmpty")
    void IsEmpty() {
    }
}