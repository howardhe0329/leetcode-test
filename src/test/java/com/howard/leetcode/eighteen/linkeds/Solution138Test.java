package com.howard.leetcode.eighteen.linkeds;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("")
class Solution138Test {

    private Solution138 solution;

    @ParameterizedTest
    @MethodSource("copyRandomListProvider")
    @DisplayName("CopyRandomList")
    void CopyRandomList(Node head) {
        solution = new Solution138();
        Node result = solution.copyRandomList(head);
        assertThat(result).isNotNull();
    }

    static Stream<Arguments> copyRandomListProvider() {
        return Stream.of(
                Arguments.arguments(generate())
        );
    }

    private static Node generate() {
        Node head = new Node(1, null, null);
        Node second = new Node(2, null, null);
        head.next = second;
        head.random = second;
        second.random = second;
        return head;
    }
}