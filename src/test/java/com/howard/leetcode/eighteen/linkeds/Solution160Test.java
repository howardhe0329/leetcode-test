package com.howard.leetcode.eighteen.linkeds;

import static org.assertj.core.api.Assertions.*;

import com.howard.leetcode.linkedlist.ListNode;
import com.howard.leetcode.linkedlist.ListNodeGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution160Test {

    private Solution160 solution;

    @ParameterizedTest
    @MethodSource("getIntersectionNodeProvider")
    @DisplayName("GetIntersectionNode")
    void GetIntersectionNode(ListNode headA, ListNode headB, int right) {
        solution = new Solution160();
        ListNode result = solution.getIntersectionNode(headA, headB);
        if (right < 0) {
            assertThat(result).isNull();
        } else {
            assertThat(result.val).isEqualTo(right);
        }
    }

    static Stream<Arguments> getIntersectionNodeProvider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(4, 1, 8, 4, 5)),
                        ListNodeGenerator.generate(Lists.newArrayList(5, 0, 1, 8, 4, 5)),
                        8),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(0, 9, 1, 2, 4)),
                        ListNodeGenerator.generate(Lists.newArrayList(3, 2, 4)),
                        2),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(2, 6, 4)),
                        ListNodeGenerator.generate(Lists.newArrayList(1, 5)),
                        -1)
        );
    }
}