package com.howard.leetcode.eighteen.linkeds;

import com.howard.leetcode.linkedlist.ListNode;
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
class Solution141Test {

    private Solution141 solution;

    @ParameterizedTest
    @MethodSource("hasCycleProvider")
    @DisplayName("HasCycle")
    void HasCycle(ListNode head, boolean right) {
        solution = new Solution141();
        boolean result = solution.hasCycle(head);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> hasCycleProvider() {
        List<Integer> list = Lists.newArrayList(3, 2, 0, 4);
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generateCycle(list, 1), true),
                Arguments.arguments(ListNodeGenerator.generateCycle(list, -1), false),
                Arguments.arguments(ListNodeGenerator.generateCycle(list, 2), true),
                Arguments.arguments(ListNodeGenerator.generateCycle(list, 3), true),
                Arguments.arguments(ListNodeGenerator.generateCycle(list, 0), true),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1)), false)
        );
    }
}