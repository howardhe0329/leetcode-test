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

@DisplayName("")
class Solution237Test {

    private Solution237 solution;

    @ParameterizedTest
    @MethodSource("deleteNodeProvider")
    @DisplayName("DeleteNode")
    void DeleteNode(ListNode node, List<Integer> right) {
        solution = new Solution237();
        solution.deleteNode(node);
        List<Integer> result = ListNodeConverter.convert(node);
        assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> deleteNodeProvider() {
        ListNode head = ListNodeGenerator.generate(Lists.newArrayList(4, 5, 1, 9));
        return Stream.of(
                Arguments.arguments(head.next, Lists.newArrayList(4, 1, 9)),
                Arguments.arguments(head.next.next, Lists.newArrayList(4, 5, 9))
        );
    }
}