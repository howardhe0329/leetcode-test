package com.howard.leetcode.eighteen.linkeds;

import static org.assertj.core.api.Assertions.*;

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

class Solution148Test {

    private Solution148 solution;

    @ParameterizedTest
    @MethodSource("sortListProvider")
    @DisplayName("SortList")
    void SortList(ListNode head) {
        solution = new Solution148();
        ListNode result = solution.sortList(head);
        assertThat(ListNodeConverter.convert(result)).isSorted();
    }

    static Stream<Arguments> sortListProvider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(4, 2, 1, 3))),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(-1, 5, 3, 4, 0)))
        );
    }
}