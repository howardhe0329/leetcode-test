package com.howard.leetcode.eighteen.linkeds;

import com.howard.leetcode.linkedlist.ListNode;
import com.howard.leetcode.linkedlist.ListNodeConverter;
import com.howard.leetcode.linkedlist.ListNodeGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class Solution328Test {

    private Solution328 solution;

    @ParameterizedTest
    @MethodSource("oddEvenListProvider")
    @DisplayName("OddEvenList")
    void OddEvenList(ListNode head, List<Integer> right) {
        solution = new Solution328();
        ListNode result = solution.oddEvenList(head);
        assertThat(ListNodeConverter.convert(result)).containsSequence(right);
    }

    static Stream<Arguments> oddEvenListProvider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 3, 4, 5)), Lists.newArrayList(1, 3, 5, 2, 4)),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(2, 1, 3, 5, 6, 4, 7)), Lists.newArrayList(2, 3, 6, 7, 1, 5, 4))
        );
    }
}