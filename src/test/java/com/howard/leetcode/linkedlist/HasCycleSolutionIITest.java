package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("有环的链表的环的起点节点")
class HasCycleSolutionIITest {

    private HasCycleSolutionII solution;

    @BeforeEach
    void setUp() {
        solution = new HasCycleSolutionII();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "detectCycle测试有环的链表返回ListNode: Test# {index}: Id: {0}")
    @DisplayName("测试有环的链表的环起点节点")
    @MethodSource("hasCycleListNodeProvider")
    void detectCycle(List<Integer> data, int pos, int right) {
        ListNode result = solution.detectCycle(ListNodeGenerator.generateCycle(data, pos));
        if (data.isEmpty() || pos < 0) {
            Assertions.assertThat(result).isNull();
        } else {
            Assertions.assertThat(result.val).isEqualTo(right);
        }
    }

    static Stream<Arguments> hasCycleListNodeProvider() {
        return Stream.of(
          Arguments.arguments(Lists.newArrayList(3, 2, 0, -4), 1, 2),
                Arguments.arguments(Lists.newArrayList(), 0, 0),
                Arguments.arguments(Lists.newArrayList(1, 2), 0, 1),
                Arguments.arguments(Lists.newArrayList(1), -1, 1)
        );
    }

}