package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("验证是否为回文链表")
class PalindromeLinkedListSolutionTest {

    private PalindromeLinkedListSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PalindromeLinkedListSolution();
    }

    @ParameterizedTest
    @MethodSource("providerTrue")
    @DisplayName("测试是回文链表")
    void isPalindromeTrue(ListNode head) {
        boolean result = solution.isPalindrome(head);
        Assertions.assertThat(result).as("是回文链表").isTrue();
    }

    @ParameterizedTest
    @MethodSource("providerFalse")
    @DisplayName("测试不是回文链表")
    void isPalindromeFalse(ListNode head) {
        boolean result = solution.isPalindrome(head);
        Assertions.assertThat(result).as("是回文链表").isFalse();
    }

    static Stream<Arguments> providerTrue() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2, 2, 1)))
        );
    }

    static Stream<Arguments> providerFalse() {
        return Stream.of(
                Arguments.arguments(ListNodeGenerator.generate(Lists.newArrayList(1, 2)))
        );
    }
}