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

class Solution234Test {

    private Solution234 solution;

    @ParameterizedTest
    @MethodSource("isPalindromeProvider")
    @DisplayName("IsPalindrome")
    void IsPalindrome(ListNode head, boolean right) {
        solution = new Solution234();
        boolean result = solution.isPalindrome(head);
        assertThat(result).isEqualTo(right);
    }

    /**
     *
     * @return
     */
    static Stream<Arguments> isPalindromeProvider() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2)), false),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 2, 1)), true),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 3, 2, 1)), true),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList()), true),
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1)), true)
        );
    }
}