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
class Solution206Test {

    private Solution206 solution;

    @ParameterizedTest
    @MethodSource("reverseListProvider")
    @DisplayName("ReverseList")
    void ReverseList(ListNode head, List<Integer> right) {
        solution = new Solution206();
        ListNode result = solution.reverseList(head);
        assertThat(ListNodeConverter.convert(result)).containsSequence(right);
    }

    static Stream<Arguments> reverseListProvider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 3, 4, 5)), Lists.newArrayList(5, 4, 3, 2, 1))
        );
    }
}