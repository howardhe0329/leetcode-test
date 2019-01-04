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

@DisplayName("两两交换链表中的节点")
class SwapPairsSolutionTest {

    private SwapPairsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SwapPairsSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试两两交换链表中的节点")
    void swapPairs(List<Integer> data, List<Integer> rightList) {
        ListNode result = solution.swapPairs(ListNodeGenerator.generate(data));
        if (rightList.isEmpty()) {
            Assertions.assertThat(result).isNull();
        } else {
            List<Integer> resultList = ListNodeConverter.convert(result);
            Assertions.assertThat(resultList).containsSequence(rightList);
        }
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4),
                        Lists.newArrayList(2, 1, 4, 3)),
                Arguments.arguments(Lists.newArrayList(1, 2, 3),
                        Lists.newArrayList(2, 1, 3)),
                Arguments.arguments(Lists.newArrayList(),
                        Lists.newArrayList()),
                Arguments.arguments(Lists.newArrayList(1),
                        Lists.newArrayList(1)),
                Arguments.arguments(Lists.newArrayList(1, 2),
                        Lists.newArrayList(2, 1))
        );
    }
}