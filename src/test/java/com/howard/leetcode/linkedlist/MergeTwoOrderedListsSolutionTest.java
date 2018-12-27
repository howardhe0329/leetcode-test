package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("合并两个有序链表")
class MergeTwoOrderedListsSolutionTest {

    private MergeTwoOrderedListsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MergeTwoOrderedListsSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("合并两个有序链表")
    void mergeTwoLists(List l1, List l2) {
        ListNode result = solution.mergeTwoLists(ListNodeGenerator.generate(l1)
                , ListNodeGenerator.generate(l2));
        List resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("不为null和empty").isNotEmpty()
            .as("包含l1中的值")
            .containsAll(l1)
            .as("包含l2中的值")
            .containsAll(l2);
    }

    @ParameterizedTest
    @MethodSource("providerIsNull")
    @DisplayName("合并两个有序链表, 参数为null的情况")
    void mergeTwoListsIsNull(List l1, List l2) {
        ListNode result = solution.mergeTwoLists(ListNodeGenerator.generate(l1)
                , ListNodeGenerator.generate(l2));
        List resultList = ListNodeConverter.convert(result);
        Assertions.assertThat(resultList).as("结果为null").isNull();
    }

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 4)
                        , Lists.newArrayList(1, 3, 4)),
                Arguments.arguments(Lists.newArrayList(3, 4, 5)
                        , Lists.newArrayList(4, 6, 7, 8, 9)),
                Arguments.arguments(Lists.newArrayList(3)
                        , Lists.newArrayList(4, 6, 7, 8, 9)),
                Arguments.arguments(Lists.newArrayList(3)
                        , Lists.newArrayList(4)),
                Arguments.arguments(Lists.newArrayList()
                        , Lists.newArrayList(4)),
                Arguments.arguments(Lists.newArrayList(3, 4)
                        , Lists.newArrayList())
        );
    }

    public static Stream<Arguments> providerIsNull() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList()
                        , Lists.newArrayList())
        );
    }

}